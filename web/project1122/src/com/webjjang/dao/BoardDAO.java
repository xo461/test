package com.webjjang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.dto.BoardDTO;
import com.webjjang.util.db.DBUtil;

public class BoardDAO {

	public List<BoardDTO> list() throws SQLException {
		
		List<BoardDTO> list = null;
		
		Connection con = DBUtil.getConnection();
	
		String sql = "select no, title, writer, "
				+ " to_char(writeDate,'yyyy-mm-dd')writeDate"
				+ " hit from board "
				+ " order by no desc ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				if(list == null)list= new ArrayList<BoardDTO>();
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriter(rs.getString("writer"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));
				list.add(dto);
			}
			
		}
		DBUtil.close(con, pstmt, rs);
		return list;
	}
}
