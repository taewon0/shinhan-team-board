package com.board;

import com.board.controller.BoardController;
import com.board.controller.CommentController;
import com.board.view.MainView;

public class Main {

	public static void main(String[] args) {

		        MainView mainView = new MainView();
		        BoardController boardController = new BoardController();
		        CommentController commentController = new CommentController(boardController.getDAO());

		        while (true) {
		            int menu = mainView.mainMenu();

		            switch (menu) {
		                case 1: boardController.addBoard(); break;
		                case 2: boardController.deleteBoard(); break;
		                case 3: boardController.listBoards(); break;
		                case 4: commentController.addComment(); break;
		                case 5: commentController.updateComment(); break;
		                case 6: commentController.deleteComment(); break;
		                case 0:
		                    System.out.println("프로그램 종료");
		                    return;
		                default:
		                    System.out.println("잘못된 입력");
		            }
		        }
		    
	}

}
