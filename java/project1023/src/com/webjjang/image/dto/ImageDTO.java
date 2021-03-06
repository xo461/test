package com.webjjang.image.dto;

public class ImageDTO {
	private int no;
	private String title;
	private String content;
	private String id;
	private String writeDate;
	private String fileName;
	{ // 초기화 블록
		title = "제목을 입력하세요";
		content = "내용";
		id = "미입력상태입니다";
		writeDate = "19-10-17";
		fileName = "파일을 첨부하세요.";
	}

	public ImageDTO() // 생성자
	{
		title = "제목을 입력하세요";
		content = "내용";
		id = "미입력상태입니다";
		writeDate = "19-10-17";
		fileName = "파일을 첨부하세요.";
	}

	public ImageDTO(String title, String content, String id, String fileName) { // 생성자
		this();
		this.title = title;
		this.content = content;
		this.id = id;
		this.fileName = fileName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "ImageDTO [no=" + no + ", title=" + title + ", content=" + content + ", id=" + id + ", writeDate="
					+ writeDate + ", fileName=" + fileName + "]";
	}
}
