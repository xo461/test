package com.webjjang.util.io;

import com.webjjang.main.SwitchMain;

public class Output {
	
	// 로그인 정보를 출력하는 메서드 
	public static void loginInfor() {
//		Output.menu("로그인 정보");
		System.out.println("================로 그 인 정 보================");
		// 로그인 정보 출력
		if(SwitchMain.login == null)
			System.out.println("======= 로그인이 되지않았습니다!!! 로그인 하슈!=======");
		else
			System.out.println("환영합니다. " + SwitchMain.login.getName()
			+ "님은 " + SwitchMain.login.getGradeName() + "권한으로 로그인 하셨습니다.");
		System.out.println("========================================");
	}

//	// 제목 출력 
	public static void title(String title) {
		System.out.println();
		printTitleLine();
		System.out.println("   " + title);
		printTitleLine();
	}
	
	// 메뉴 출력
	// String으로 데이터 여러개 menus[] -> 갯수는 상관이 없다. 
	public static void menu(String... menus) {
		printLine();
		for(String menu : menus)
			System.out.println("   "+menu);
		printLine();
	}
	
	// 제목 출력시 출력이 되는 라인 출력 
	public static void printTitleLine( ) {
		printLine("=",20);
	}
	
	// 라인 출력 - 출력되는 문자, 반복 횟수 (길이)
	public static void printLine(String type, int cnt) {
		for(int i = 1; i <= cnt; i++ )
			System.out.print(type);
		System.out.println();
	}
	// 라인 출력 - 출력되는 문자, 반복 횟수 (길이)
	public static void printLine(int cnt) {
		printLine("-",cnt);
	}
	public static void printLine() {
		printLine("-",30);
	}
	
}

















