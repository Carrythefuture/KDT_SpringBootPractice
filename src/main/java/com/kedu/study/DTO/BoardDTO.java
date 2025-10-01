package com.kedu.study.DTO;

public class BoardDTO {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String createdAt;
	
	public BoardDTO(int seq, String id, String title, String content, String createdAt) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	
	
}
