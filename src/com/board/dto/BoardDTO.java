package com.board.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    
    public BoardDTO(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	private List<CommentDTO> comments = new ArrayList<>();
}
