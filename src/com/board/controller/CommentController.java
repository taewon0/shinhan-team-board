package com.board.controller;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;
import com.board.service.CommentService;
import com.board.view.BoardView;


public class CommentController {

    private CommentService commentService = new CommentService();
    private BoardView view = new BoardView();
    private BoardService boardService;

    public CommentController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void addComment() {
        int boardId = view.inputBoardId();
        BoardDTO board = boardService.getBoard(boardId);
        if (board == null) {
            view.showMessage("게시물이 없습니다.");
            return;
        }

        String content = view.inputComment();
        commentService.addComment(board, content);
        view.showMessage("댓글 추가 완료");
    }

    public void updateComment() {
        int boardId = view.inputBoardId();
        BoardDTO board = boardService.getBoard(boardId);
        if (board == null) {
            view.showMessage("게시물이 없습니다.");
            return;
        }

        int commentId = view.inputCommentId();
        String content = view.inputComment();
        if (commentService.updateComment(board, commentId, content)) {
            view.showMessage("댓글 수정 완료");
        } else {
            view.showMessage("댓글이 없습니다.");
        }
    }

    public void deleteComment() {
        int boardId = view.inputBoardId();
        BoardDTO board = boardService.getBoard(boardId);
        if (board == null) {
            view.showMessage("게시물이 없습니다.");
            return;
        }

        int commentId = view.inputCommentId();
        if (commentService.deleteComment(board, commentId)) {
            view.showMessage("댓글 삭제 완료");
        } else {
            view.showMessage("댓글이 없습니다.");
        }
    }
}