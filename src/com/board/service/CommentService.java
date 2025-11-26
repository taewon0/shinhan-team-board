package com.board.service;

import java.util.List;

import com.board.dao.CommentDAO;
import com.board.dto.BoardDTO;
import com.board.dto.CommentDTO;

public class CommentService {

	private CommentDAO commentDAO = new CommentDAO();

	public void addComment(BoardDTO board, String content) {
		commentDAO.addComment(board, content);
	}

	public boolean updateComment(BoardDTO board, int commentId, String content) {
		return commentDAO.updateComment(board, commentId, content);
	}

	public boolean deleteComment(BoardDTO board, int commentId) {
		return commentDAO.deleteComment(board, commentId);
	}
	
	public List<CommentDTO> findByBoardId(int id) {
		return commentDAO.findByBoardId(id);
	}
	
}
