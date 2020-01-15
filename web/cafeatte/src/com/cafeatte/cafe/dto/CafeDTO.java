package com.cafeatte.cafe.dto;

public class CafeDTO {
	private int no;
	private String id;
	private String title;
	private String addr;
	private String tel;
	private String parking;
	private String open;
	private String holiday;
	private String menu;
	private String writeDate;
	private int hit;
	private int replyCnt;
	private String fileName1;
	private String fileName2;
	private String fileName3;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public String getFileName1() {
		return fileName1;
	}
	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}
	public String getFileName2() {
		return fileName2;
	}
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}
	public String getFileName3() {
		return fileName3;
	}
	public void setFileName3(String fileName3) {
		this.fileName3 = fileName3;
	}
	@Override
	public String toString() {
		return "CafeDTO [no=" + no + ", id=" + id + ", title=" + title + ", addr=" + addr + ", tel=" + tel
				+ ", parking=" + parking + ", open=" + open + ", holiday=" + holiday + ", menu=" + menu + ", writeDate="
				+ writeDate + ", hit=" + hit + ", replyCnt=" + replyCnt + ", fileName1=" + fileName1 + ", fileName2="
				+ fileName2 + ", fileName3=" + fileName3 + "]";
	}
}
