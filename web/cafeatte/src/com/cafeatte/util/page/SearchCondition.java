package com.cafeatte.util.page;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SearchCondition {

	// 검색을 SQL쿼리에 추가하는 메서드 //수정하기---------------------------------------
	public static String getSearchSQLWithWhere(PageObject pageObject) {
		System.out.println("SearchCondition.getSearchSQLWithWhere()");
		String sql = "";
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " where 1 = 2 ";
			if (pageObject.getKey().indexOf("t") >= 0)
				sql += " or title like ? ";
			if (pageObject.getKey().indexOf("c") >= 0)
				sql += " or content like ? ";
			if (pageObject.getKey().indexOf("w") >= 0)
				sql += " or id like ? ";
		}
		return sql;
	}

	public static String getSearchSQLWithWhereMember(PageObject pageObject) {
		System.out.println("SearchCondition.getSearchSQLWithWehreMember");
		String sql = "";

		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " where 1 = 2 ";
			if (pageObject.getKey().indexOf("i") >= 0)
				sql += " OR id LIKE ? ";
			if (pageObject.getKey().indexOf("n") >= 0)
				sql += " OR nickName LIKE ? ";
		}

		return sql;
	}

	//UserCafe용...
	public static String getSearchSQLWithWhereUserCafe(PageObject pageObject) {
		System.out.println("SearchCondition.getSearchSQLWithWhereUserCafe");
		String sql="";
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			sql += " and 1=2 ";
			if (pageObject.getKey().indexOf("t") >= 0)
				sql += " or title like ? ";
			if (pageObject.getKey().indexOf("c") >= 0)
				sql += " or content like ? ";
			if (pageObject.getKey().indexOf("n") >= 0)
				sql += " or nickName like ? ";
		}
		return sql;
	}

	// 실행객체에 검색 데이터를 셋팅하는 메서드 //수정하기---------------------------------------
	public static int setPreparedStatement(PreparedStatement pstmt, PageObject pageObject, int idx) throws Exception {
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			if (pageObject.getKey().indexOf("t") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("c") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("w") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
		}
		return idx;
	}

	public static int setPreparedStatementMember(PreparedStatement pstmt, PageObject pageObject, int idx)
			throws Exception {
		if (pageObject.getWord() != null && !pageObject.getWord().equals("")) {
			if (pageObject.getKey().indexOf("i") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("n") >= 0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
		}
		return idx;
	}
	
	//UserCafe용...
	public static int setPreparedStatementUserCafe(PreparedStatement pstmt, PageObject pageObject, int idx) throws Exception {
		if (pageObject.getWord()!=null&&!pageObject.getWord().equals("")) { 
			if (pageObject.getKey().indexOf("t")>=0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("c")>=0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
			if (pageObject.getKey().indexOf("n")>=0)
				pstmt.setString(idx++, "%" + pageObject.getWord() + "%");
		}
		return idx;
	}
}
