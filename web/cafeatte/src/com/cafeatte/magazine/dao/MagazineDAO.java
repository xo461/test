package com.cafeatte.magazine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cafeatte.magazine.dto.MagazineDTO;
import com.cafeatte.util.db.DBUtil;
import com.cafeatte.util.page.PageObject;
import com.cafeatte.util.page.SearchCondition;

public class MagazineDAO {

	 //-----------------------------------------------------------------------------
	 //-----------------------list list list list list list-------------------------
	 //-----------------------------------------------------------------------------	
	
	public List<MagazineDTO> list(PageObject pageObject) throws Exception{
		
		System.out.println("MagazineDAO.list()");
		
		List<MagazineDTO> list = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select no, title, subTitle, content, id, "
				+ " to_char(writeDate,'yyyy-mm-dd')writeDate, "
				+ " to_char(startDate,'yyyy-mm-dd')startDate, "
				+ " to_char(endDate,'yyyy-mm-dd')endDate, "
				+ " hit, fileName "
				+ " from Magazine ";
		
		sql     += SearchCondition.getSearchSQLWithWhere(pageObject);
    	sql		+= "order by no desc ";
    	
    	// 2)위에서 정렬 시킨 데이터에 순서 번호를 붙인다.
    	sql = " select rownum rnum, no, title, subTitle, content, id, "
    			+ " writeDate, startDate, endDate, hit, fileName "
    			+ " from( " + sql + ") ";
    	
    	// 3)페이지에 맞는 시작번호와 끝번호 사이의 데이터를 가져온다. 
    	
    	sql = " select * " 
    			+ " from( " + sql + ") "
    			+ " where rnum between ? and ? ";

    	System.out.println("MagazineDAO.list().sql:" + sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		
		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
    	pstmt.setInt(idx++, pageObject.getStartRow());
    	pstmt.setInt(idx++, pageObject.getEndRow());
    	
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			
			while(rs.next()) {
    			
    			if(list == null)list = new ArrayList<MagazineDTO>();
    			
    			MagazineDTO dto = new MagazineDTO();
    			
    			dto.setNo(rs.getInt("no"));
    			dto.setTitle(rs.getString("title"));
    			dto.setSubTitle(rs.getString("subTitle"));
    			dto.setContent(rs.getString("content"));
    			dto.setId(rs.getString("id"));
    			dto.setFileName(rs.getString("fileName"));
    			dto.setWriteDate(rs.getString("writeDate"));
    			dto.setStartDate(rs.getString("startDate"));
    			dto.setEndDate(rs.getString("endDate"));
    			dto.setHit(rs.getInt("hit"));
    		
    			list.add(dto);
    		}// end of while(rs.next())
    	}// end of if(rs == null)
			
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("Magazine.list().list"+list);
		
		return list;
		
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------mlist mlist mlist mlist mlist mlist-------------------------
	//-----------------------------------------------------------------------------	
	
	public List<MagazineDTO> mlist(PageObject pageObject) throws Exception{
		
		System.out.println("MagazineDAO.m_list()");
		
		List<MagazineDTO> mlist = null;
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select no, title, subTitle, content, id, "
				+ " to_char(writeDate,'yyyy-mm-dd') writeDate, "
				+ " to_char(startDate,'yyyy-mm-dd') startDate, "
				+ " to_char(endDate,'yyyy-mm-dd') endDate, "
				+ " hit, fileName "
				+ " from Magazine WHERE endDate > SYSDATE ";
		
//		sql     += SearchCondition.getSearchSQLWithWhere(pageObject);
		sql		+= "order by endDate desc ";
		
		
		sql = " select rownum rnum, no, title, subTitle, content, id, "
				+ " writeDate, startDate, endDate, hit, fileName "
				+ " from( " + sql + " ) ";
		
		sql 	= " select * from( " + sql + ") "
				+ " where rnum between 1 and 6 ";
		System.out.println("MagazineDAO.list().sql:" + sql);
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int idx = 1;
		
//		idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);
//		pstmt.setInt(idx++, pageObject.getStartRow());
//		pstmt.setInt(idx++, pageObject.getEndRow());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			
			while(rs.next()) {
				
				if(mlist == null)mlist = new ArrayList<MagazineDTO>();
				
				MagazineDTO dto = new MagazineDTO();
			
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setSubTitle(rs.getString("subTitle"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setFileName(rs.getString("fileName"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setStartDate(rs.getString("startDate"));
				dto.setEndDate(rs.getString("endDate"));
				dto.setHit(rs.getInt("hit"));
				
				mlist.add(dto);
				
				
				
			}// end of while(rs.next())
		}// end of if(rs == null)
		
		DBUtil.close(con, pstmt, rs);
		
		System.out.println("Magazine.list().list" + mlist);
		
		return mlist;
		
	}
	
	 //-----------------------------------------------------------------------------
	 //-----------------------TotalRow TotalRow TotalRow TotalRow TotalRow TotalRow--------------------
	 //-----------------------------------------------------------------------------
	
	
	 public int getTotalRow(PageObject pageObject) throws Exception{
	    	
	    	System.out.println("MagazineDAO.getTotalRow().pageObject:"+pageObject);
	    	
	    	// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 한다. 
	    	int totalRow = 0;
	    	
	    	// 데이터 가져오는 처리문
	    	// 1.드라이버 확인,2.연결 객체
	    	Connection con = DBUtil.getConnection();

	    	// 3.실행한 쿼리문작성
	    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
	    	String sql = " select count(*) cnt from magazine ";
	    	
	    	sql += SearchCondition.getSearchSQLWithWhere(pageObject);
	    	System.out.println("MagazineDAO.getTotal().sql:" + sql);
	    	// 4.실행객체 가져오기 / 데이터 셋팅
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
	    	int idx = 1;
	    	idx = SearchCondition.setPreparedStatement(pstmt, pageObject, idx);

	    	// 5.실행
	    	ResultSet rs = pstmt.executeQuery();
	    	// 6.표시 /저장
	    	if(rs != null && rs.next()) {
	    		totalRow = rs.getInt("cnt");
	    		    		
	    	}// end of if(rs != null&& rs.next())
	    	
	    	
	    	// 7.닫기
	        DBUtil.close(con, pstmt, rs);
	      	
	    	System.out.println("MagazineDAO.getTotalRow().totlaRow"+totalRow);
	    	
	    	return totalRow;
	    } // end of getTotalRow()
	 
	 
	 //-----------------------------------------------------------------------------
	 //-----------------------view view view view view view view--------------------
	 //-----------------------------------------------------------------------------
	 
	    
	    public MagazineDTO view(int no) throws Exception{
	    	
	    	System.out.println("MagazineDAO.view().no:" + no);
	    	
	    	// 가져온 결과가 저장되어 지는 변수 -> 리턴해야 하므로 리턴 타입과 같아야 한다. 
	    	MagazineDTO dto = null;
	    	
	    	// 데이터 가져오는 처리문
	    	// 1.드라이버 확인
         	// 2.연결 객체
	    	// 3.실행한 쿼리문작성
	    	Connection con = DBUtil.getConnection();
	    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
	    	String sql = "select no, title, subTitle, content, id, "
					+ " to_char(writeDate,'yyyy-mm-dd')writeDate, "
					+ " to_char(startDate,'yyyy-mm-dd')startDate, "
					+ " to_char(endDate,'yyyy-mm-dd')endDate, "
					+ " fileName "
					+ " from Magazine where no = ? ";
	    	
	    	System.out.println("MagazineDAO.list().sql:" + sql);
	    	// 4.실행객체 가져오기 / 데이터 셋팅
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	pstmt.setInt(1, no);
	    	// 5.실행
	    	ResultSet rs = pstmt.executeQuery();
	    	// 6.표시 /저장
	    	if(rs != null && rs.next()) {
	    		
	    			dto = new MagazineDTO();
	    			// 데이처를 담는다. rs에서 꺼내서  dto에
	    			dto.setNo(rs.getInt("no"));
	    			dto.setTitle(rs.getString("title"));
	    			dto.setSubTitle(rs.getString("subTitle"));
	    			dto.setContent(rs.getString("content"));
	    			dto.setId(rs.getString("id"));
	    			dto.setFileName(rs.getString("fileName"));
	    			dto.setWriteDate(rs.getString("writeDate"));
	    			dto.setStartDate(rs.getString("startDate"));
	    			dto.setEndDate(rs.getString("endDate"));
	    			
	    	}// end of if(rs != null&& rs.next())
	   	
	    	
	    	// 7.닫기
	    	con.close();
	    	pstmt.close();
	    	rs.close();
	    	
	    	System.out.println("MagazineDAO.view().dto:"+dto);
	    	
	    	return dto;
	    } // end of view()
	    
 //-----------------------------------------------------------------------------
 //-----------------------write write write write write write-------------------------
 //-----------------------------------------------------------------------------	
	    
	    
	    public int write(MagazineDTO dto) throws Exception{
	    
	    	System.out.println("MagazineDAO.write().dto:" + dto);
	    	
	    	
	    	
	    	// 1.드라이버 확인/ 2.연결 객체
	    	Connection con = DBUtil.getConnection();
	    	// 3.실행한 쿼리문작성
	    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
	    	
	    	String sql = " insert into magazine(no, id, title, subTitle, content, fileName, startDate, "
	    			+ " endDate ) "
					+ " values(magazine_seq.nextval, ?, ?, ?, ?, ?, ?, ?) ";
			
	    	System.out.println("MagazineDAO.write().sql:"+sql);
	    	
	 
	    	// 4.실행객체 가져오기 / 데이터 셋팅
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
	    	pstmt.setString(1, dto.getId());
	    	pstmt.setString(2, dto.getTitle());
	    	pstmt.setString(3, dto.getSubTitle());
	    	pstmt.setString(4, dto.getContent());
	    	pstmt.setString(5, dto.getFileName());
	    	pstmt.setString(6, dto.getStartDate());
	    	pstmt.setString(7, dto.getEndDate());
	    	// 5.실행
	    	// select -> executeQuery();
	    	// insert, update, delete -> executeUpdate
	    	int result = pstmt.executeUpdate();
	    	// 6.표시 /저장
	    	System.out.println("매거진 등록 성공 ");
	    			
	    	// 7.닫기
	    	
	    	DBUtil.close(con, pstmt);
			return result;
	    } // end of write()
	    
	    
	 //-----------------------------------------------------------------------------
	//-----------------------update update update update update update--------------
    //-----------------------------------------------------------------------------	
	    
	    public int update(MagazineDTO dto) throws Exception{
	    	
	    	// 확인해야할 데이터 - 번호, 제목, 내용, 작성자 
	    	System.out.println("MagazineDAO.update().dto:" + dto);
	    	
	    	
	    	
	    	// 1.드라이버 확인

//	    	// 2.연결 객체
	    	Connection con = DBUtil.getConnection();
	    	// 3.실행한 쿼리문작성
	    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
	    	String sql = " update magazine set title = ?, subTitle = ?, "
	    			+ " content = ?, startDate = ?, endDate = ?, "
	    			+ " writeDate = sysdate ";
	    	if (dto.getFileName() != null && !dto.getFileName().equals(""))
				sql += " , fileName = ? ";
	    		sql += " where no = ? ";

		System.out.println("MagazineDAO.update().sql:"+sql);
	    	// 4.실행객체 가져오기 / 데이터 셋팅
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	int idx = 1;
	    	pstmt.setString(idx++, dto.getTitle());
	    	pstmt.setString(idx++, dto.getSubTitle());
			pstmt.setString(idx++, dto.getContent());
			pstmt.setString(idx++, dto.getStartDate());
			pstmt.setString(idx++, dto.getEndDate());
			
			// 첨부파일이 있는 경우 처리
			if (dto.getFileName() != null && !dto.getFileName().equals(""))
				pstmt.setString(idx++, dto.getFileName());
			
			pstmt.setInt(idx++, dto.getNo());
			
	    
	    	// 5.실행
	    	// select -> executeQuery();
	    	// insert, update, delete -> executeUpdate
	    	int result = pstmt.executeUpdate();
	    	// 6.표시 /저장
	    	System.out.println("매거진 수정 성공 ");
	    	
	    	// 7.닫기
	    	DBUtil.close(con, pstmt);
	    	
	    	return result;
	    } // end of update()
	  
	    
	    //-----------------------------------------------------------------------------
		//-----------------------delet delete delete delete delete---------------------
	    //-----------------------------------------------------------------------------
	    
	    public int delete(int no) throws Exception{
	    	
	    	// 확인해야할 데이터 - 번호
	    	System.out.println("MagazineDAO.delete().no:" + no);
	    	
	    	
	    	
	    	// 1.드라이버 확인
//	    	// 2.연결 객체
	    	Connection con = DBUtil.getConnection();
	    	// 3.실행한 쿼리문작성
	    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
	    	String sql = "delete from magazine"
	    			+ " where no = ?";
	    	System.out.println("MagazineDAO.delete().sql:"+sql);
	    	// 4.실행객체 가져오기 / 데이터 셋팅
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
	    	pstmt.setInt(1, no);
	    	
	    	// 5.실행
	    	// select -> executeQuery();
	    	// insert, update, delete -> executeUpdate
	    	int result = pstmt.executeUpdate();
	    	// 6.표시 /저장
	    	System.out.println("매거진 삭제 성공 ");
	    	
	    	// 7.닫기
	    	DBUtil.close(con, pstmt);
	    	return result;
	    } // end of delete()


	 //-----------------------------------------------------------------------------
	//-----------------------hit hit hit hit hit hit hit hit hit hit  --------------
	//------------------------------------------------------------------------------
	    
	    public void  increaseHit(int no) throws Exception{
	    	
	    	// 확인해야할 데이터 -  관련글번호, 순서번호 
	    	System.out.println("MagazineDAO.increaseHit().dto:" + no);
	    		
	
	    	// 1.드라이버 확인
	    	// 2.연결 객체
	    	Connection con = DBUtil.getConnection();
	    	// 3.실행한 쿼리문작성
	    	// 쿼리문 중에서 ?는 값을 대체 시키는 대체 문자에 해당이 된다. 
	    	String sql = " update magazine set hit = hit + 1 "
	    			+ " where no = ? ";
	    	System.out.println("magazineDAO.increaseHit().sql:" + sql);
	    	// 4.실행객체 가져오기 / 데이터 셋팅
	    	PreparedStatement pstmt = con.prepareStatement(sql);
	    	// pstmt.setInt(?의 위치,?를 대체 해야할 값)
	    	pstmt.setInt(1, no);
	    	// 5.실행
	    	// select -> executeQuery();
	    	// insert, update, delete -> executeUpdate
	    	int result = pstmt.executeUpdate();
	    	if(result > 0)
	    		// 6.표시 /저장
	    		System.out.println("조회수 1증가 성공");
	    	else {
	    		System.out.println("조회수 1증가 되지 않았습니다.");
	    		throw new Exception("조회수 1증가처리 중 오류 ");
	    	}
	    	// 7.닫기
	    	DBUtil.close(con, pstmt);
	    
	    } // end of increaseOrdNo()
	    
}
