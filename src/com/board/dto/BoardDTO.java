package com.board.dto;

import java.util.ArrayList;
import java.util.List;

public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private List<CommentDTO> comments = new ArrayList<>();

    public BoardDTO(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public List<CommentDTO> getComments() { return comments; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
}
