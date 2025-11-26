package com.board.view;

import java.util.Scanner;

public class MainView {
    private Scanner sc = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("\n===== 게시판 메뉴 =====");
        System.out.println("1. 게시글 추가");
        System.out.println("2. 게시글 삭제");
        System.out.println("3. 게시글 목록 보기");
        System.out.println("4. 댓글 추가");
        System.out.println("5. 댓글 수정");
        System.out.println("6. 댓글 삭제");
        System.out.println("0. 종료");
        System.out.print("선택: ");
        return Integer.parseInt(sc.nextLine());
    }
}