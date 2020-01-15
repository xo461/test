package com.webjjang.util.io;

import java.util.Scanner;

public class Input {

	// scanner는 클래스 내에서만 사용한다.
	// 수정 불가능 / 자주 사용되기 때문에 static으로 선언 (생성하지 않고 사용) Input.getString()
	private final static Scanner scanner = new Scanner(System.in);

	// 문자열을 받아내는 메서드 Input.getString()

	public static String getString() {
		return scanner.nextLine();
	}

	// 입력메시지 출력하고 문자열 받아내는 메서드 -> 메시지 출력 후 줄바꿈 안하고 입력
	public static String getStringWithMessage(String msg) {
		System.out.print(msg + " : ");
		return getString();
	}

	// int 데이터 받기
	public static int getInt() throws Exception {
		return Integer.parseInt(getString());
	}

	// int로 입력할 때 예외 처리하는 메서드 -> 숫자로 입력할 때까지 무한 반복
	public static int getIntOfSmart() {
		while (true) {
			try {
				return getInt(); // 정상적인 숫자가 입력되면 값 돌려주면서 메서드를 빠져 나간다.
			} catch (Exception e) {
				System.out.println("숫자가 아닌 데이터가 입력되었습니다.");
			}
		}
	}
	// 입력메시지 출력하고 문자열 받아내는 메서드 -> 메시지 출력 후 줄바꿈 안하고 입력
	public static int getIntWithMessageOfSmart(String msg) {
		System.out.print(msg + " : ");
		return getIntOfSmart();
	}
	
}