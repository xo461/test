package com.webjjang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.webjjang.main.Main;
import com.webjjang.member.dto.LoginDTO;
import com.webjjang.util.db.DBUtil;

public class LoginDAO {

	public LoginDTO login(LoginDTO dto) throws Exception {
		System.out.println("MemberDAO.login().dto:"+dto);
		
		LoginDTO outDTO = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select m.id, m.name, m.grade, g.gradeName from member m, grade g where (m.id=? and m.pw=?) and (m.grade=g.grade) ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()) {
			outDTO = new LoginDTO();
			outDTO.setId(rs.getString("Id"));
			outDTO.setName(rs.getString("Name"));
			outDTO.setGrade(rs.getInt("Grade"));
			outDTO.setGradeName(rs.getString("GradeName"));
		}
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("MemberDAO.login().outDTO:"+outDTO);
		
		if(outDTO == null) {
			System.out.println("ID 또는 Password를 잘못 입력하셨습니다. 다시 입력해주세요.");
			Main.login();
		}
		return outDTO;
	}
	
	public void increaseConDate(LoginDTO dto) throws Exception{
		System.out.println("LoginDAO.increaseConDate().dto:"+dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " update member set conDate = sysdate "
				+ " where id = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		
		int result = pstmt.executeUpdate();
		
		if (result > 0)
			System.out.println("최근 접속일 갱신");
		else System.out.println("최근 접속일 실패");
		DBUtil.close(con, pstmt);
	}
}
