package com.webjjang.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.member.dto.MemberDTO;

public class MemberDAO {

	String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
	String id = "c##dogfoot";
	String pw = "dogfoot";
	String driver = "oracle.jdbc.driver.OracleDriver";

	public List<MemberDTO> list() throws Exception {
		System.out.println("MemberDTO.list()");

		List<MemberDTO> list = null;
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pw);
		String sql = "select id, pw, name, gender, birth, tel, email, regdate, condate, status, grade"
				+ " from Member order by desc";
		System.out.println("MemberDTO.list().sql:" + sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				if (list == null)
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
				dto.setCondate(rs.getString("condate"));
				dto.setStatus(rs.getString("status"));
				dto.setGrade(rs.getInt("grade"));
				list.add(dto);
			}
		}
		con.close();
		ps.close();
		rs.close();

		System.out.println("MemberDAO.list().list:" + list);

		return list;

	} // 리스트 끝
public MemberDTO view(String name) throws Exception{
		
		System.out.println("MemberDAO.view().grade:" + name);
		
		MemberDTO dto = null;
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pw);
		String sql = "select id, pw, name, gender, birth, tel, email, regdate, condate, status, grade"
				+ "from member where id = ?";
		System.out.println("MemberDTO.view().sql:" + sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
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
		con.close();
		ps.close();
		rs.close();
		
		System.out.println("MemberDAO.list().dto:"+dto);
		
		return dto;
} // 보기 끝
public void write(MemberDTO dto) throws Exception{
	
	System.out.println("MemberDAO.write().dto:" + dto);
	
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, id, pw);
	String sql = "insert into member(id, pw, name, gender, birth, tel, email, regdate, condate, status, grade)"
			+ "values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	System.out.println("MemberDTO.write().sql:" + sql);
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, dto.getPw());
	ps.setString(2, dto.getGender());
	ps.setString(3, dto.getBirth());
	ps.setString(4, dto.getTel());
	ps.setString(5, dto.getEmail());
	ps.setString(6, dto.getRegdate());
	ps.setString(7, dto.getCondate());
	ps.setString(8, dto.getStatus());
	ps.setInt(9, dto.getGrade());

	ps.executeUpdate();
	
	System.out.println("등록 성공");
	
	con.close();
	ps.close();
	
} // 등록 끝

public void update(MemberDTO dto) throws Exception{
	
	System.out.println("MemberDAO.update().dto:" + dto);
	
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, id, pw);
	String sql = " update member set pw = ?, name = ?, gender = ?, birth = ?, tel = ?, email = ?, regdate = ?, condate = ?, status = ?, grade = ?)"
			+ "values(member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	System.out.println("MemberDTO.update().sql:" + sql);
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(2, dto.getPw());
	ps.setString(3, dto.getGender());
	ps.setString(4, dto.getBirth());
	ps.setString(5, dto.getTel());
	ps.setString(6, dto.getEmail());
	ps.setString(7, dto.getRegdate());
	ps.setString(8, dto.getCondate());
	ps.setString(9, dto.getStatus());
	ps.setInt(10, dto.getGrade());

	ps.executeUpdate();
	
	System.out.println("수정 성공");
	
	con.close();
	ps.close();
}

public void delete(String id) throws Exception{
	
	System.out.println("MemberDAO.delete().id:" + id);
	
	
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, id, pw);
	String sql = " delete from member " + " where no = ? ";
	System.out.println("MemberDTO.delete().sql:" + sql);
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, id);

	ps.executeUpdate();
	
	System.out.println("삭제 성공");
	
	con.close();
	ps.close();
}
}