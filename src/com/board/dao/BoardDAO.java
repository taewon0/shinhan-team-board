package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDTO;


public class BoardDAO {

    private List<BoardDTO> boards = new ArrayList<>();
    private int boardSeq = 1;

    public BoardDTO addBoard(String title, String content) {
    	BoardDTO board = new BoardDTO(boardSeq++, title, content);
        boards.add(board);
        return board;
    }

    public boolean deleteBoard(int id) {
        return boards.removeIf(b -> b.getId() == id);
    }

    public BoardDTO getBoard(int id) {
        return boards.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<BoardDTO> getAllBoards() {
        return boards;
    }
}