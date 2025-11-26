package com.board.dto;

public class CommentDTO {
    private int id;
    private String content;

    public CommentDTO(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}