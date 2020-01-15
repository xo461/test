package com.webjjang.util.io;

//import com.webjjang.main.Main;

public class Output {

	// 로그인 정보를 출력하는 메서드
//	public static void loginStatus() {
//		// 로그인 정보 출력
//		System.out.println("   [로그인 정보]");
//		printLine(37, "-");
//		if (Main.login == null)
//			System.out.println("   로그인 되지 않았습니다.");
//		else
//			System.out.println("   환영합니다. " + Main.login.getName() + "님" + " " + Main.login.getGradeName() + " 권한으로 로그인 하셨습니다.");
//		printLine(37, "-");
//	} // end of loginStatus()
//	
	// 제목 출력
	public static void title(String title) {
		System.out.println();
		printTitleLine();
		System.out.printf("    %s%n", title);
		printTitleLine();
	}
	
	// 메뉴 출력
	// String으로 데이터 여러개 받기 가능 -> menus[] -> 갯수는 상관이 없다.
	public static void menu(String ... menus) {
		printLine();
		for(String s : menus) {
			System.out.println("   "+s);
		}
		printLine();
	}
	
	
	// 리스트 출력
	public static void list(String line) {
		System.out.println();
		printList();
		System.out.println("    == "+line+"  ==  ");
		printList();	
	}
	
	// 제목 출력시 위 아래에 출력이 되는 라인 출력
	public static void printTitleLine() { // 길이를 바꿀 수 없고 문자를 바꿀 수가 없다.
		printLine(45, "=");
	}

	public static void printLine() { // 길이를 바꿀 수 없고 문자를 바꿀 수가 없다.
		printLine(45, "-");
	}
	
	public static void printLine(int length) { // 길이를 바꿀 수 없고 문자를 바꿀 수가 없다.
		printLine(length, "-");
	}
	
	public static void printList() {
		printLine(30, "*");
	}
	
	
	public static void printLine(int length, String type) { // 길이를 바꿀 수 없고 문자를 바꿀 수가 없다.
		for(int i = 1; i <= length; i++)
			System.out.print(type);
		System.out.println();
	}
}
