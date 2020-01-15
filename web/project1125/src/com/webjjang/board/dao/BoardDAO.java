package com.webjjang.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.util.db.DBUtil;

import sun.security.action.GetIntegerAction;

public class BoardDAO {

	public List<BoardDTO> list() throws Exception{
		
		List<BoardDTO> list = null;
//		1. 드라이버 확인 2.연결객체
		
		Connection con = DBUtil.getConnection();
		
//		3. spl
		
		String sql = " selet no, title, content, writer, "
				+ " to_char(writeDate, yyyy-mm-dd)writeDate,"
				+ " hit from board "
				+ " order by desc ";
//		4. 실행객체 & 데이터 셋팅
		PreparedStatement pstmt = con.prepareStatement(sql);
//		5. 실행
		ResultSet rs = pstmt.executeQuery();
//		6. 데이터 표시
		if(rs != null)
			while(rs.next())
				if(list == null)list = new ArrayList<BoardDTO>();
		BoardDTO dto = new BoardDTO();		
		dto.setNo(rs.getInt("no"));
		dto.setTitle(rs.getString("title"));
		dto.setContent(rs.getString("content"));
		dto.setWriter(rs.getString("writer"));
		dto.setWriteDate(rs.getString("writeDate"));
		dto.setHit(rs.getInt("hit"));
		list.add(dto);
		
		//		7. 닫기
		DBUtil.close(con, pstmt, rs);
		return list;
		
	}
	
}
