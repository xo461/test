package com.cafeatte.coupon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafeatte.coupon.dto.CouponDTO;
import com.cafeatte.util.db.DBUtil;

public class CouponDAO {

	public void send(CouponDTO dto) throws Exception{
		Connection con = DBUtil.getConnection();
		
		String sql = " INSERT INTO coupon (cno, id, title, content, fileName, cafe_no, endDate) "
				+ " VALUES(coupon_seq.nextval, ?, ?, ?, ?, ?, ? ) ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, dto.getSender());
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3, dto.getContent());
		pstmt.setString(4, dto.getFileName());
		pstmt.setInt(5, dto.getCafe_no());
		pstmt.setString(6, dto.getEndDate());
		
		pstmt.executeUpdate();
		
		DBUtil.close(con, pstmt);
	}
	
	public List<CouponDTO> list(String id) throws Exception {
		List<CouponDTO> list = null;
		List<CouponDTO> usedList = usedList(id);
		CouponDTO[] usedDto = {new CouponDTO()};
		if(usedList != null) {
			usedDto = usedList.toArray(new CouponDTO[usedList.size()]);
		}
		Connection con = DBUtil.getConnection();
		
		String sql = " SELECT cno, id, title, content, cafe_no, fileName, TO_CHAR(endDate, 'yyyy-mm-dd') endDate FROM coupon ORDER BY cno DESC ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				if(list == null) {
					list = new ArrayList<CouponDTO>();
				}
				CouponDTO nUseDto = new CouponDTO();
				nUseDto.setCno(rs.getInt("cno"));
				nUseDto.setSender(rs.getString("id"));
				nUseDto.setTitle(rs.getString("title"));
				nUseDto.setContent(rs.getString("content"));
				nUseDto.setCafe_no(rs.getInt("cafe_no"));
				nUseDto.setFileName(rs.getString("fileName"));
				String smallPhoto = nUseDto.getFileName();
				int pos = smallPhoto.lastIndexOf("/");
				smallPhoto = smallPhoto.substring(0, pos + 1) + "s_" + smallPhoto.substring(pos + 1);
				nUseDto.setFileName(smallPhoto);
				nUseDto.setEndDate(rs.getString("endDate"));
				list.add(nUseDto);
				
				for(int i = 0; i < usedDto.length; i++) {
					if(nUseDto.getCno() == usedDto[i].getCno()) {
						list.remove(nUseDto);
					}
					
				}
			}
		}
		
		DBUtil.close(con, pstmt, rs);
		return list;
	}
	
	public List<CouponDTO> usedList(String id) throws Exception {
		List<CouponDTO> list = null;
		System.out.println("usedList : " + id);
		
		Connection con = DBUtil.getConnection();
		
		String sql = " SELECT cno, id, no FROM couponUsed WHERE id = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs != null) {
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<CouponDTO>();
				CouponDTO usedDto = new CouponDTO();
				usedDto.setCno(rs.getInt("cno"));
				usedDto.setCafe_no(rs.getInt("no"));
				usedDto.setUsedId(rs.getString("id"));
				System.out.println(usedDto);
				list.add(usedDto);

			}
		}
		
		System.out.println("usedList : " + list);
		DBUtil.close(con, pstmt, rs);
		return list;
	}
	
	public CouponDTO view(int cno) throws Exception {
		Connection con = DBUtil.getConnection();
		CouponDTO dto = null;
		String sql = " SELECT cno, id, title, content, cafe_no, fileName, TO_CHAR(endDate, 'yyyy-mm-dd') endDate FROM coupon WHERE cno = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, cno);
		
		ResultSet rs = pstmt.executeQuery();
	
		if(rs.next()) {
			dto = new CouponDTO();
			dto.setCno(rs.getInt("cno"));
			dto.setSender(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setCafe_no(rs.getInt("cafe_no"));
			dto.setFileName(rs.getString("fileName"));
			dto.setEndDate(rs.getString("endDate"));
		}
		DBUtil.close(con, pstmt, rs);
		return dto;
	}
	
	public void use(CouponDTO dto) throws Exception {
		Connection con = DBUtil.getConnection();
		
		String sql = " INSERT INTO couponUsed(no, id, cno) VALUES (?, ?, ?) ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getCafe_no());
		pstmt.setString(2, dto.getUsedId());
		pstmt.setInt(3,  dto.getCno());
		
		pstmt.executeUpdate();
		
		DBUtil.close(con, pstmt);
	}
	
	public void update(CouponDTO dto) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = " UPDATE coupon SET title = ?, content = ?, fileName = ?, endDate = ?, cafe_no = ? WHERE cno = ?";
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getTitle());
		pstmt.setString(2, dto.getContent());
		pstmt.setString(3, dto.getFileName());
		pstmt.setString(4, dto.getEndDate());
		pstmt.setInt(5, dto.getCafe_no());
		pstmt.setInt(6, dto.getCno());

		pstmt.executeUpdate();
		
		DBUtil.close(con, pstmt);
	}
	
}
