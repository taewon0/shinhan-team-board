package com.board.service;

import java.util.List;

import com.board.dao.BoardDAO;
import com.board.dto.BoardDTO;

public class BoardService {

	private BoardDAO boardDAO = new BoardDAO();

	public void addBoard(String title, String content) {
		boardDAO.addBoard(title, content);
	}

	public boolean deleteBoard(int id) {
		return boardDAO.deleteBoard(id);
	}

	public List<BoardDTO> getAllBoards() {
		return boardDAO.getAllBoards();
	}

	public BoardDTO getBoard(int id) {
		return boardDAO.getBoard(id);
	}
	
	
	
	
}
