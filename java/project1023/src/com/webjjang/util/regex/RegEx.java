package com.webjjang.util.regex;

import java.util.regex.Pattern;

public class RegEx {
	
	// 사용하는 데이터의 정규 표현 문자열
	public static final String emailReg = "^[a-zA-Z0-9._%+_]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
	public static final String emailErrorMsg = "데이터가 이메일 패턴이 아닙니다.\n 이메일은 맨 앞에 영문자로 시작하고 중간에 '@'이 들어가야 합니다.";
	public static final String cellReg ="^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$";
	public static final String cellErrorMsg = "핸드폰번호를 잘못 입력하셨습니다.\n 하이픈(-)을 포함 ex)010-1234-5678";
	public static final String birthReg = "^[0-9]{2}(0[1-9]{1}|1[0-2]{1})(0[1-9]|[12][0-9]|[3][01])$";
	public static final String birthErrorMsg = "생년월일을 잘못 입력하셨습니다. \n생년월일은 주민등록번호 앞 자리를 입력해주세요.";
	public static final String idReg = "^[a-zA-Z]{1}[0-9a-zA-Z]{3,19}$";
	public static final String idErrorMsg = "아이디를 잘못 입력하셨습니다. \n아이디는 첫자는 영문자, 이후 특수문자없이 4자부터 20자까지입니다.";
	public static final String pwReg = "^[^ㄱ-힣]{4,20}$";
	public static final String pwErrorMsg = "비밀번호를 잘못 입력하셨습니다. \n비밀번호는 영문자, 특수문자 포함(한글제외) 4자이상 20자 이하입니다.";
	
	public static boolean matchRegEx(String patternStr, String data) {

		return Pattern.compile(patternStr).matcher(data).matches();
	}
}
