package com.webjjang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webjjang.member.dto.LoginDTO;
import com.webjjang.member.dto.MemberDTO;
import com.webjjang.util.db.DBUtil;

public class MemberDAO {

	public LoginDTO login(LoginDTO dto)throws Exception {
		// TODO Auto-generated method stub
		// 입력 데이터 확인 - 아이디, 비밀 번호
		System.out.println("MemberDAO.login().dto:" + dto);
		// 리턴할 결과를 저장하는 변수 
		LoginDTO outDTO = null;
		
		// 1. 드라이버 확인/ 2. 연결 객체
		Connection con = DBUtil.getConnection();
		//3.sql문 작성
		String sql = " select m.id, m.name, m.grade, g.gradeName "
				+ " from member m, grade g "
				+ " where (m.id = ? and m.pw = ?) "// 일반조건
				+ " and (m.grade = g.grade) "; // 조인 조건 *조인을 먼저시키면 속도가 느려진다. 
		
		// 4. 실행 객체 / 데이터 셋팅 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		// 5.실행
		ResultSet rs = pstmt.executeQuery();
		
		// 6. 데이터 표시 / 저장 
		if(rs != null && rs.next()) {
			outDTO = new LoginDTO();
			outDTO.setId(rs.getString("id"));
			outDTO.setName(rs.getString("name"));
			outDTO.setGrade(rs.getInt("grade"));
			outDTO.setGradeName(rs.getString("gradeName"));
		}
				
		// 7. 닫기
		DBUtil.close(con, pstmt, rs);
		
		// 결과 확인 
		System.out.println("MemberDAO.login().outDTO:" + outDTO);
		//결과가 null인 경우 - 아이디와 비밀번호가 틀린 경우 : 예외 발생 
//		if(outDTO == null) 
//			throw new Exception("로그인 실패 : 아이디나 비밀번호를 확인하고 다시 시도해 주세요!");
		return outDTO;
	}

	// 회원가입 메서드 
	public Integer join(MemberDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		//1. 드라이버 확인 / 2.연결객체 
		Connection con = DBUtil.getConnection();
		
		//3. sql
		String sql = "insert into member(id, pw, name, gender, birth, "
				+ " tel, email) "
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		
		//4. 실행객체
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getGender());
		pstmt.setString(5, dto.getBirth());
		pstmt.setString(6, dto.getTel());
		pstmt.setString(7, dto.getEmail());
		
		//5. 실행
		int result = pstmt.executeUpdate();
		
		//6. 표시저장 
		System.out.println("회원가입 성공");
		
		//7. 닫기
		return result;
	}

}
















