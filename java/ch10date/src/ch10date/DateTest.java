package ch10date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 오늘 날짜 객체
		Date today = new Date();
		System.out.println(today);
		int yy = today.getYear();
		System.out.println(yy); // 119? -> 컴퓨터의 시작일 : 0 
		yy += 1900;
		System.out.println(yy);
		int mm = today.getMonth();
		System.out.println(mm); 
		// 월 : 0 ~ 11 까지만 사용한다. 
		//요일(getDate) : 0 ~ 6까지만 사용한다. 
		mm++;
		System.out.println(mm);
		int dd = today.getDate();
		System.out.println(dd);
		// 오늘 날짜 형식에 맞춰서 출력한다.
		System.out.println(yy + "-" + mm + "-" + dd);

		// 날짜 형식을 만들어 주는 객체 ->SimpleDateformat
		// 타입을 날짜폼객체 생성하면서 파라매터로 아무것도 전달하지 않으면 기본 형식 사용
		// 기본 형식 : 년 2자리 월 일 오전 /오후  시:분
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(today));
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(today));
		
		// 오늘 날짜 셋팅 -> 날짜를 지정 
		Date day1 = new Date(yy - 1900, mm-1, dd);
		System.out.println(sdf.format(day1));
		
		Date chriDate = new Date(today.getYear(), 12-1, 25);
		System.out.println(sdf.format(chriDate));
		
		Date day2 = new Date("10/28/2019");
		System.out.println(sdf.format(day2));
	}

}






















