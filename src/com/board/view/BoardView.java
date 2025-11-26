package com.board.view;

import java.util.List;
import java.util.Scanner;

import com.board.dto.BoardDTO;
import com.board.dto.CommentDTO;



public class BoardView {

    private Scanner sc = new Scanner(System.in);

    public String inputTitle() {
        System.out.print("제목: ");
        return sc.nextLine();
    }

    public String inputContent() {
        System.out.print("내용: ");
        return sc.nextLine();
    }

    public int inputBoardId() {
        System.out.print("게시글 번호 입력: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int inputCommentId() {
        System.out.print("댓글 번호 입력: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String inputComment() {
        System.out.print("댓글 내용: ");
        return sc.nextLine();
    }

    public void showBoards(List<BoardDTO> boards) {
        System.out.println("\n=== 게시글 목록 ===");
        for (BoardDTO b : boards) {
            System.out.println(b.getId() + ". " + b.getTitle());
            for (CommentDTO c : b.getComments()) {
                System.out.println("   - (" + c.getId() + ") " + c.getContent());
            }
        }
        System.out.println();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}