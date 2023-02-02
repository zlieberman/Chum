package com.zlieberman.chum.model;

import java.util.List;

import lombok.Data;

@Data
public class Post {
	
	private ChumUser author;
	private String content;
	private int likes;
	private List<Comment> comments;
	
}
