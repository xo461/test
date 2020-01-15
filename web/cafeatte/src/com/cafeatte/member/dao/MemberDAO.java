package com.cafeatte.member.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafeatte.member.dto.LoginDTO;
import com.cafeatte.member.dto.MemberDTO;
import com.cafeatte.util.db.DBUtil;
import com.cafeatte.util.page.PageObject;
import com.cafeatte.util.page.SearchCondition;

public class MemberDAO {

	public MemberDTO view(String id) throws Exception {
		System.out.println("view()" + id);
		MemberDTO dto = null;
		String sql = "";
		Connection con = DBUtil.getConnection();
		sql = " SELECT m.id, m.nickName, m.addr, m.tel, m.photo, m.email, m.state, g.grade, s.stateName, g.gradeName "
				+ " FROM member m, state s, grade g WHERE id = ? and (m.state = s.state) and (g.grade = m.grade) ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs != null && rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setNickName(rs.getString("nickName"));
			dto.setAddr(rs.getString("addr"));
			dto.setTel(rs.getString("tel"));
			dto.setEmail(rs.getString("email"));
			dto.setPhoto(rs.getString("photo"));
			dto.setGrade(rs.getInt("grade"));
			dto.setState(rs.getInt("state"));
			dto.setGradeName(rs.getString("gradeName"));
			dto.setStateName(rs.getString("stateName"));
		}
		
		DBUtil.close(con, pstmt, rs);
		
		return dto;
	}
	
	public LoginDTO login(LoginDTO dto) throws Exception {
		System.out.println("MemberDAO.login()");
		
		String sql = "";
		
		LoginDTO outDTO = null;
		
		Connection con = DBUtil.getConnection();
		
		sql = " SELECT m.id, m.pw, m.nickName, m.grade, g.gradeName, m.state, s.stateName, m.photo FROM member m, grade g, state s "
				+ " WHERE (m.id = ? and m.pw = ?) and (m.grade = g.grade) and (m.state = s.state ) ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()) {
			outDTO = new LoginDTO();
			outDTO.setId(rs.getString("id"));
			outDTO.setPw(rs.getString("pw"));
			outDTO.setNickName(rs.getString("nickName"));
			outDTO.setGrade(rs.getInt("grade"));
			outDTO.setState(rs.getInt("state"));
			outDTO.setGradeName(rs.getString("gradeName"));
			outDTO.setStateName(rs.getString("stateName"));
			outDTO.setPhoto(rs.getString("photo"));
			String smallPhoto = outDTO.getPhoto();
			int pos = smallPhoto.lastIndexOf("/");
			smallPhoto = smallPhoto.substring(0, pos + 1) + "s_" + smallPhoto.substring(pos + 1);
			outDTO.setPhoto(smallPhoto);
			updateConDate(outDTO.getId());
		}
		return outDTO;

	}
	
	public void updateConDate(String id) throws SQLException {
		Connection con = DBUtil.getConnection();
		String sql = " UPDATE member SET conDate = SYSDATE WHERE id = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		
		DBUtil.close(con, pstmt);
	}
	
	public Integer pwCheckService(String id, String pw) throws Exception{
		System.out.println("MemberDAO.pwCheckService() id + pw " + id + pw);
		int result = 0;
		Connection con = DBUtil.getConnection();
		
		String sql = " SELECT id FROM member WHERE id = ? and pw = ? ";
		System.out.println("MemberDAO.pwCheckService().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs!= null && rs.next()) {
			result = 1;
		}
		DBUtil.close(con, pstmt, rs);
		
		System.out.println(result);
		return result;
	}
	
	public Integer changePw(String id, String newPw) throws Exception{
		System.out.println("MemberDAO.changePw()");
		
		Connection con = DBUtil.getConnection();

		String sql = " UPDATE member SET pw = ? WHERE id = ? ";
		System.out.println("MemberDAO.update().sql:" + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, newPw);
		pstmt.setString(2, id);

		int result = pstmt.executeUpdate();

		DBUtil.close(con, pstmt);

		
		return result;
	}
	
	public String findId(String email) throws Exception{
		System.out.println("MemberDAO.findId().email : " + email);
		String id = null;
		Connection con = DBUtil.getConnection();

		String sql = " SELECT id FROM member WHERE email = ? ";
		System.out.println("MemberDTO.list().sql:" + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, email);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs!=null&&rs.next())
			id = rs.getString("id");
		return id;
	}
	
	public MemberDTO findPwForm(String id, String email) throws Exception {
		MemberDTO dto = null;
		Connection con = DBUtil.getConnection();
		
		String sql = " SELECT question, id, email FROM member WHERE id = ? and email = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, email);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs!=null&&rs.next()) {
			dto = new MemberDTO();
			dto.setQuestion(rs.getString("question"));
			dto.setId(rs.getString("id"));
			dto.setEmail(rs.getString("email"));
		}
		DBUtil.close(con, pstmt, rs);
		return dto;
	}
	
	public String findPw(String id, String answer) throws Exception{
		System.out.println("MemberDAO.findPw().id answer : " + id + " " + answer);
		String pw = "";
		Connection con = DBUtil.getConnection();

		String sql = " SELECT pw FROM member WHERE id = ? AND answer = ?  ";
		System.out.println("MemberDTO.list().sql:" + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, answer);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs != null&&rs.next()) {
			pw = rs.getString("pw");
		}
		return pw;
	}
	
	public int join(MemberDTO dto) throws Exception{
		Connection con = DBUtil.getConnection();
		System.out.println("MemberDAO.join().dto : " + dto);
		String sql = " INSERT INTO member(id, pw, addr, tel, email, question, answer, photo, nickname) " + 
				" VALUES (?, ? , ?, ?, ?, ?, ?, ?, ?) ";
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getAddr());
		pstmt.setString(4, dto.getTel());
		pstmt.setString(5, dto.getEmail());
		pstmt.setString(6, dto.getQuestion());
		pstmt.setString(7, dto.getAnswer());
		pstmt.setString(8, dto.getPhoto());
		pstmt.setString(9, dto.getNickName());
		
		int result = pstmt.executeUpdate();
		if (result > 0) {
			System.out.println("회원 등록에 성공했습니다.");

		}
		DBUtil.close(con, pstmt);

		return result;
		
		
	}
	
	public void  signOut(String id) throws Exception {

		System.out.println("MemberDAO.signOut().id:" + id);

		Connection con = DBUtil.getConnection();

		String sql = " UPDATE member SET state = 3 WHERE id = ? ";
		System.out.println("MemberDAO.delete().sql:" + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);

		int result = pstmt.executeUpdate();

		if (result > 0)
			System.out.println("삭제 성공");
		else
			System.out.println("삭제가 되지 않았습니다. -id를 확인하세요.");

		DBUtil.close(con, pstmt);

	} // end of signOut()
	
	public int update(MemberDTO dto) throws Exception {
		// 회원 정보 수정
		System.out.println("MemberDAO.update().dto:" + dto);

		Connection con = DBUtil.getConnection();

		String sql = " UPDATE member SET addr = ?, tel = ?, email = ?, photo = ? WHERE id = ? ";
		System.out.println("MemberDAO.update().sql:" + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getAddr());
		pstmt.setString(2, dto.getTel());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getPhoto());
		pstmt.setString(5, dto.getId());

		int result = pstmt.executeUpdate();

		DBUtil.close(con, pstmt);
		
		return result;

	} // end of update
	
	public List<MemberDTO> list(PageObject pageObject) throws Exception {

		System.out.println("MemberDAO.list()");

		List<MemberDTO> list = null;

		Connection con = DBUtil.getConnection();

		String sql = " SELECT m.id, m.nickName, m.addr, m.email, m.photo, g.gradeName, s.stateName FROM member m, grade g, state s "
		+ " WHERE (m.grade = g.grade) and (m.state = s.state ) ";
		sql = " SELECT ROWNUM rnum, id, nickName, addr, email, photo, gradeName, stateName FROM ( " + sql + " ) ";
		sql += SearchCondition.getSearchSQLWithWhereMember(pageObject);
		sql += " ORDER BY id ";
		sql = " SELECT rnum, id, nickName, addr, email, photo, gradeName, stateName FROM ( " + sql + " ) WHERE rnum BETWEEN ? and ? ";
		System.out.println("MemberDTO.list().sql:" + sql);
		int idx=1;
		PreparedStatement pstmt = con.prepareStatement(sql);
		idx = SearchCondition.setPreparedStatementMember(pstmt, pageObject, idx);
		pstmt.setInt(idx++, pageObject.getStartRow());
		pstmt.setInt(idx++, pageObject.getEndRow());
		ResultSet rs = pstmt.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<MemberDTO>();
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setNickName(rs.getString("nickName"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoto(rs.getString("photo"));
				String smallPhoto = dto.getPhoto();
				int pos = smallPhoto.lastIndexOf("/");
				smallPhoto = smallPhoto.substring(0, pos + 1) + "s_" + smallPhoto.substring(pos + 1);
				dto.setPhoto(smallPhoto);
				dto.setGradeName(rs.getString("gradeName"));
				dto.setStateName(rs.getString("stateName"));
				System.out.println(dto);
				list.add(dto);

			}
		}
		DBUtil.close(con, pstmt, rs);
		System.out.println("MemberDAO.list().list:" + list);
		return list;

	} // end of list
	
	public int getTotalRow(PageObject pageObject) throws Exception {
		// TODO Auto-generated method stub
		int totalRow = 0;

		Connection con = DBUtil.getConnection();
		String sql = " SELECT COUNT(*) totalRow FROM member ";
		sql += SearchCondition.getSearchSQLWithWhereMember(pageObject);		
			
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		idx = SearchCondition.setPreparedStatementMember(pstmt, pageObject, idx);
		ResultSet rs = pstmt.executeQuery();
		if (rs != null && rs.next())
			totalRow = rs.getInt("totalRow");
		DBUtil.close(con, pstmt, rs);
		System.out.println("MemberDAO.getTotalRow.totalRow : " + totalRow);
		return totalRow;
	} // end of MemberDAO.getTotalRowl();


	public String idCheck(String id) throws Exception {
			
		Connection con = DBUtil.getConnection();
		
		String sql = " SELECT id FROM member WHERE id = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		String idCheckResult = null;
		ResultSet rs = pstmt.executeQuery();
		if(rs!=null && rs.next()) {
			idCheckResult = rs.getString("id");
		}
		DBUtil.close(con, pstmt, rs);
		return idCheckResult;
	}
	
	public void changeState(String id, int state) throws Exception {
		Connection con = DBUtil.getConnection();
		
		String sql = " UPDATE member SET state = ? WHERE id = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, state);
		pstmt.setString(2, id);
		
		pstmt.executeUpdate();
		DBUtil.close(con, pstmt);
	}
	
	public void changeGrade(String id, int grade) throws Exception {
		Connection con = DBUtil.getConnection();
		
		String sql = " UPDATE member SET grade = ? WHERE id = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, grade);
		pstmt.setString(2, id);
		
		pstmt.executeUpdate();
		DBUtil.close(con, pstmt);
		
	}
	
	public String checkNewPw(String id, String newPw) throws Exception {
		Connection con = DBUtil.getConnection();
		
		String sql = " SELECT pw FROM member WHERE id = ? and pw = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, newPw);
		String pwCheckResult = null;
		ResultSet rs = pstmt.executeQuery();
		if(rs!=null && rs.next()) {
			pwCheckResult = rs.getString("pw");
		}
		DBUtil.close(con, pstmt, rs);
		return pwCheckResult;
	}
}
