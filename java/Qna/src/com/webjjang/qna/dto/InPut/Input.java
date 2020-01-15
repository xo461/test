package com.webjjang.qna.dto.InPut;

import java.util.Scanner;

public class Input {

	private final static Scanner scanner = new Scanner(System.in);
	
	public static String getString() {
		return scanner.nextLine();
	}
	public static String getStringWithMessage(String msg) {
		System.out.println(msg + "-->");
		return getString();
		
	}
	public static int getInt() throws Exception{
		return Integer.parseInt(getString());
	}
	
	public static int getInOfSmart() {
		while(true) {
		try {
			return getInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("================================");
			System.out.println("| 숫자가 아닌 데이터가 입력되었습니다!확인하세요! |");
			System.out.println("================================");
		}
	}
		
	}
	public static int getIntWithMessageOfSmart(String msg) {
		System.out.print(msg + "--->");
		return getInOfSmart();
	}
	

}

