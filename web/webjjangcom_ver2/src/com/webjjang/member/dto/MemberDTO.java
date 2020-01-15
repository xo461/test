/*
 * 회원 데이터 저장하는 객체
 * DB 컬럼에 맞춰서 작성한다. + 처리된 결과
 */
package com.webjjang.member.dto;

public class MemberDTO {

	// private - 개인적인 : 클래스 내에서만 사용한다.
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birth;
	private String tel;
	private String email;
	private String regDate;
	private String conDate;
	private String status;
	private int grade;
	// grade 회원가입시 일반 회원은 1이다. 관리자 9
	// 데이터를 꺼내올 때 : getMethod를 작성,
	// 데이터를 넣을 때 : setMethod를 작성
	// 보안이나 데이터관리에 있어서 효율적이다.
	// 프레임워크 : JSP, Spring -> 강제하고 있다. -> property
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getConDate() {
		return conDate;
	}
	public void setConDate(String conDate) {
		this.conDate = conDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	// 개발자의 데이터 확인용
	// 어노테이션 - Over ride vs. Over load
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", birth=" + birth
				+ ", tel=" + tel + ", email=" + email + ", regDate=" + regDate + ", conDate=" + conDate + ", status="
				+ status + ", grade=" + grade + "]";
	}
	
}
