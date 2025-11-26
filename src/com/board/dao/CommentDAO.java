package com.board.dao;


import com.board.dto.BoardDTO;
import com.board.dto.CommentDTO;

public class CommentDAO {

    public void addComment(BoardDTO board, String content) {
        int nextId = board.getComments().size() + 1;
        board.getComments().add(new CommentDTO(nextId, content));
    }

    public boolean deleteComment(BoardDTO board, int commentId) {
        return board.getComments().removeIf(c -> c.getId() == commentId);
    }

    public boolean updateComment(BoardDTO board, int commentId, String newContent) {
        for (CommentDTO c : board.getComments()) {
            if (c.getId() == commentId) {
                c.setContent(newContent);
                return true;
            }
        }
        return false;
    }
}