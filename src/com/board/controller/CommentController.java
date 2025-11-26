package com.board.controller;

import com.board.dao.BoardDAO;
import com.board.dao.CommentDAO;
import com.board.dto.BoardDTO;
import com.board.view.BoardView;


public class CommentController {

    private CommentDAO commentDAO = new CommentDAO();
    private BoardView view = new BoardView();
    private BoardDAO boardDAO;

    public CommentController(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public void addComment() {
        int boardId = view.inputBoardId();
        BoardDTO board = boardDAO.getBoard(boardId);
        if (board == null) {
            view.showMessage("게시물이 없습니다.");
            return;
        }

        String content = view.inputComment();
        commentDAO.addComment(board, content);
        view.showMessage("댓글 추가 완료");
    }

    public void updateComment() {
        int boardId = view.inputBoardId();
        BoardDTO board = boardDAO.getBoard(boardId);
        if (board == null) {
            view.showMessage("게시물이 없습니다.");
            return;
        }

        int commentId = view.inputCommentId();
        String content = view.inputComment();
        if (commentDAO.updateComment(board, commentId, content)) {
            view.showMessage("댓글 수정 완료");
        } else {
            view.showMessage("댓글이 없습니다.");
        }
    }

    public void deleteComment() {
        int boardId = view.inputBoardId();
        BoardDTO board = boardDAO.getBoard(boardId);
        if (board == null) {
            view.showMessage("게시물이 없습니다.");
            return;
        }

        int commentId = view.inputCommentId();
        if (commentDAO.deleteComment(board, commentId)) {
            view.showMessage("댓글 삭제 완료");
        } else {
            view.showMessage("댓글이 없습니다.");
        }
    }
}