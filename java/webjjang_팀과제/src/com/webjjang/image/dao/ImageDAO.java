package com.webjjang.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.main.Main;
import com.webjjang.util.db.DBUtil;

public class ImageDAO {

	public List<ImageDTO> list() throws Exception {
		List<ImageDTO> list = null;

		Connection con = DBUtil.getConnection();
		String sql = " select * from ( select rownum rnum, no, title, content, id, writeDate, fileName from ("
					+ " select no, title, content, id, to_char(writeDate, 'yyyy-mm-dd') writeDate, fileName from image order by no desc )"
					+ " ) where rnum between 1 and 10 ";
		System.out.println("ImageDAO.list().sql" + sql);
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<ImageDTO>();
				ImageDTO dto = new ImageDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setWriteDate(rs.getString("writeDate"));
				list.add(dto);
			}
		}
		DBUtil.close(con, pstmt, rs);
		System.out.println("ImageDAO.list().list : " + list);
		return list;
	}

	public ImageDTO view(int no) throws Exception {
		ImageDTO dto = null;
		Connection con = DBUtil.getConnection();
		String sql = " select no, title, content, id, to_char(writeDate, 'yyyy-mm-dd') writeDate, fileName from image where no = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs != null && rs.next()) {
			dto = new ImageDTO();
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setId(rs.getString("id"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setFileName(rs.getString("fileName"));
		}
		DBUtil.close(con, pstmt, rs);
		System.out.println("ImageDAO.view().dto : " + dto);
		return dto;
	}

	public void write(ImageDTO dto) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = " insert into image( no, title, content, id, fileName) values(image_seq.nextval, ?, ?, ?, ?) ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, Main.login.getId());
		pstmt.setString(4, dto.getFileName());
		pstmt.executeUpdate();
		System.out.println("이미지 글 쓰기 성공");
		DBUtil.close(con, pstmt);
	}
	
	public void update(ImageDTO dto) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = " update image set title = ?, content = ?, id = ?, fileName =? where no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getId());
		pstmt.setString(4, dto.getFileName());
		pstmt.setInt(5, dto.getNo());
		pstmt.executeUpdate();
		DBUtil.close(con, pstmt);
	}

	public void delete(int no) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = " delete from image where no = ? ";
		System.out.println("ImageDAO.delete().sql" + sql);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		System.out.println("이미지 글 삭제 성공");
		DBUtil.close(con, pstmt);
	}
}
