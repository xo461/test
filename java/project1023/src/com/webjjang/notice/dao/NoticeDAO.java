package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;


public class NoticeDAO {

	String url = "jdbc:oracle:thin:@402-oracle:1521:orcl";
	String id = "c##dogfoot";
	String pw = "dogfoot";

	String driver ="oracle.jdbc.driver.OracleDriver";

	
	
	//1\. �Խ��� ����Ʈ ��������
	
	public List<NoticeDTO> list() throws Exception {
		
		System.out.println("NoticeDAO.list()");
		
		List<NoticeDTO> list = null;
		//��ü���� ����� DB ���� -> list(), view()... �ٸ� �޼��忡�� �� �ʿ�� �ϱ� ������
		//���������� �����Ѵ�.
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pw);
		
		String sql = " select no, title, to_char(startDate, 'yyyy-mm-dd') startDate, to_char(endDate,'yyyy-mm-dd') endDate, to_char(writeDate,'yyyy-mm-dd') writeDate, to_char(updateDate, 'yyyy-mm-dd') updateDate from notice order by no desc ";
		
		
		
		System.out.println("NoticeDAO.list().sql : "+sql);

		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				//���������� ������ list�� null�� ��쿡�� �����ؼ� ��밡���ϵ��� ���ش�.
				if(list == null) 
					list = new ArrayList<NoticeDTO>();
				//
				
				//�Խ��� �ϳ��� �����͸� ��� ��ü ����
				NoticeDTO dto = new NoticeDTO();
				//�����ʹ��
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title"));
				dto.setStartDate(rs.getString("StartDate"));
				dto.setEndDate(rs.getString("EndDate"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setUpdateDate(rs.getString("UpdateDate"));
				
				list.add(dto);
				
				
			}// end of while
		}// end of if
		
		con.close();
		pstmt.close();
		rs.close();
				
		System.out.println("NoticeDAO.list().list :"+list);
		return list;
		//end of list
		
	}





//2. �Խ��� �ۺ��� ������ ��������
//�۹�ȣ�� ���� �Ѱ� ������ ���޹޴´�
//������ �������� �����ϸ� ����ó���� �ݵ�� �ؾ��� (throw��Ű�°����� ��� ����)
public NoticeDTO view(int no) throws Exception {
	
	System.out.println("NoticeDAO.view().no : "+no);
	
	NoticeDTO dto = null;
	//��ü���� ����� DB ���� -> list(), view()... �ٸ� �޼��忡�� �� �ʿ�� �ϱ� ������
	//���������� �����Ѵ�.
	


//������ �������� ó����
	//?�� ���� ��ü��Ű�� ��ü���ڿ� �ش��
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, id, pw);

String sql = " select no, title, content, to_char(startDate, 'yyyy-mm-dd') startDate, to_char(endDate,'yyyy-mm-dd') endDate, to_char(writeDate,'yyyy-mm-dd') writeDate, to_char(updateDate, 'yyyy-mm-dd') updateDate from notice where no = ? ";
System.out.println("NoticeDAO.list().sql : "+sql);

PreparedStatement pstmt = con.prepareStatement(sql);

//?�� ��ġ, ?�� ��ü�ؾ� �� ��
pstmt.setInt(1, no);

ResultSet rs = pstmt.executeQuery();

if(rs != null && rs.next()) {
			// ���������� ������ list�� null�� ��쿡�� �����ؼ� ��밡���ϵ��� ���ش�.

			// �Խ��� �ϳ��� �����͸� ��� ��ü ����
			dto = new NoticeDTO();
			// �����ʹ��
			dto.setNo(rs.getInt("no"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("Content"));
			dto.setStartDate(rs.getString("StartDate"));
			dto.setEndDate(rs.getString("EndDate"));
			dto.setWriteDate(rs.getString("writeDate"));
			dto.setUpdateDate(rs.getString("UpdateDate"));
		
	}// end of while

con.close();
pstmt.close();
rs.close();
		
System.out.println("NoticeDAO.list().dto :"+dto);

return dto;

}//end of list








//2. �Խ��� �ۺ��� ������ ��������
//�۹�ȣ�� ���� �Ѱ� ������ ���޹޴´�
//������ �������� �����ϸ� ����ó���� �ݵ�� �ؾ��� (throw��Ű�°����� ��� ����)
public void write(NoticeDTO dto) throws Exception {
	
	System.out.println("NoticeDAO.write().dto : "+dto);
	

//������ �������� ó����
	//?�� ���� ��ü��Ű�� ��ü���ڿ� �ش��
	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, id, pw);

String sql = " insert into notice(no, title, content) "
+" values(notice_seq.nextval, ?, ? ) ";
System.out.println("NoticeDAO.write().sql : "+sql);

PreparedStatement pstmt = con.prepareStatement(sql);

//?�� ��ġ, ?�� ��ü�ؾ� �� ��
pstmt.setString(1, dto.getTitle());
pstmt.setString(2, dto.getContent());

//5. 실행
		// select -> executeQuery()
		// insert, update, delete -> executeUpdate()
		pstmt.executeUpdate();
		// 6. 표시 / 저장
		System.out.println("글쓰기 성공");

con.close();
pstmt.close();

}//end of write
}

