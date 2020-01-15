package com.webjjang.board.dto;

public class BoardReplyDTO {
	private int rno;
	private int no;
	private String content, writer, writeDate;

	//댓글 달기용 생성자
	public BoardReplyDTO(int no, String content, String writer) {
		super();
		this.no = no;
		this.content = content;
		this.writer = writer;
	}
	
	//기본생성자
	public BoardReplyDTO() {
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		return "BoardReplyDTO [rno=" + rno + ", no=" + no + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + "]";
	}


}
