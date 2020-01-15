package com.webjjang.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.member.dto.MemberDTO;
import com.webjjang.util.db.DBUtil;

public class MemberDAO {

	public List<MemberDTO> list() throws Exception{
		
		System.out.println("MemberDAO.list()");
		
		List<MemberDTO> list = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select id, pw, name, to_char(birth, 'yyyy-mm-dd') birth, gender, tel, email, to_char(regdate, 'yyyy-mm-dd') regdate, status, grade"
				+ " from Member ";
//				+ " where i.id = m.id "
				
		System.out.println("MemberDTO.list().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				if(list == null)
					list = new ArrayList<MemberDTO>();
				
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setStatus(rs.getString("status"));
				dto.setGrade(rs.getInt("grade"));
				list.add(dto);
				
			}
		}
		DBUtil.close(con, pstmt, rs);
		System.out.println("MemberDAO.list().list:" + list);
		return list;
		
	} // 리스트 끝
	
	public MemberDTO view(String id) throws Exception{
		
		System.out.println("MemberDAO.view().id:"+id);
		
		MemberDTO dto = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = " select id, pw, name, to_char(birth, 'yyyy-mm-dd') birth, gender, tel, email, to_char(regdate, 'yyyy-mm-dd') regdate, to_char(condate, 'yyyy-mm-dd') condate, status, grade "
				+ " from member where id = ? ";
		System.out.println("MemberDTO.view().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()) {
				
				dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCondate(rs.getString("condate"));
				dto.setStatus(rs.getString("status"));
				dto.setGrade(rs.getInt("grade"));				
			
		}
		DBUtil.close(con, pstmt, rs);
		System.out.println("MemberDAO.list().list:" + dto);
		return dto;
		
	} // 보기 끝
	
	public void write(MemberDTO dto) throws Exception{
		
		System.out.println("MemberDAO.write().dto:"+dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " insert into member(id, pw, name, birth, gender, tel, email, grade) "
				+ " values(?, ?, ?, ?, ?, ?, ?, ?) ";
		System.out.println("MemberDTO.write().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getBirth());
		pstmt.setString(5, dto.getGender());
		pstmt.setString(6, dto.getTel());
		pstmt.setString(7, dto.getEmail());
		pstmt.setInt(8, dto.getGrade());
		
		pstmt.executeUpdate();
		
	
		System.out.println("등록 성공");
		
						
		DBUtil.close(con, pstmt);
		
		
	} // 등록 끝
	
	public void update(MemberDTO dto) throws Exception{
		
		System.out.println("MemberDAO.update().dto:"+dto);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " update member set name = ?, birth = ?, gender = ?, tel = ?, email = ?, grade = ? "
		+ " where id = ? ";
		System.out.println("MemberDAO.update().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getBirth());
		pstmt.setString(3, dto.getGender());
		pstmt.setString(4, dto.getTel());
		pstmt.setString(5, dto.getEmail());
		pstmt.setInt(6, dto.getGrade());
		pstmt.setString(7, dto.getId());
		
		int result = pstmt.executeUpdate();
		
		if(result>0)
			System.out.println("수정 성공");
		else System.out.println("수정이 되지 않았습니다. -id를 확인하세요.");
		
				
		DBUtil.close(con, pstmt);
		
		
	} // 수정 끝
	
	public void delete(String id) throws Exception{
		
		System.out.println("MemberDAO.delete().id:"+id);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " delete from member "
		+ " where id = ? ";
		System.out.println("MemberDAO.delete().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		int result = pstmt.executeUpdate();
		
		if(result>0)
			System.out.println("삭제 성공");
		else System.out.println("삭제가 되지 않았습니다. -id를 확인하세요.");
		
				
		DBUtil.close(con, pstmt);
		
		
	} // 삭제 끝
	

}
