package com.board.controller;


import com.board.dao.BoardDAO;
import com.board.view.BoardView;

public class BoardController {

    private BoardDAO boardDAO = new BoardDAO();
    private BoardView boardView = new BoardView();

    public void addBoard() {
        String title = boardView.inputTitle();
        String content = boardView.inputContent();
        boardDAO.addBoard(title, content);
        boardView.showMessage("게시글이 등록되었습니다.");
    }

    public void deleteBoard() {
        int id = boardView.inputBoardId();
        if (boardDAO.deleteBoard(id)) {
            boardView.showMessage("게시글 삭제 완료");
        } else {
            boardView.showMessage("해당 게시글이 존재하지 않습니다.");
        }
    }

    public void listBoards() {
        boardView.showBoards(boardDAO.getAllBoards());
    }

    public BoardDAO getDAO() {
        return boardDAO;
    }

	public void contentsBoard() {
		int id = boardView.inputBoardId();
		boardView.showBoardContents(boardDAO.getBoard(id));
	}
}