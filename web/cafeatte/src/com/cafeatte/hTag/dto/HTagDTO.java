package com.cafeatte.hTag.dto;

public class HTagDTO {
	private String hTag;
	private int no;
	
	public String gethTag() {
		return hTag;
	}
	public void sethTag(String hTag) {
		this.hTag = hTag;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "HTagDTO [hTag=" + hTag + ", no=" + no + "]";
	}

}
