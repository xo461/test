package ch09java.lang.util.regex;

import java.util.regex.Pattern;

public class RegExUtil2 {
	// 사용하는 데이터의 정규 표현 문자열 -> 밖에서 가져다가 사용하는 변수  
	public static final String emailpattern 
	= "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
	public static final String emailErrorMsg 
	= "데이터가 이메일 패턴이 아닙니다.\n 이메일은 맨 앞에 영문자로 시작하고 중간에 '@'이 들어가야 합니다.";

	// 데이터가 패턴에 일치하는지 알아내는 메서드
	// data가 패턴에 맞으면 true가 리턴 되고 맞지 않으면 false가 리턴된다.
	public static boolean matchRegEx(String patternStr, String data) {
	    return Pattern.compile(patternStr).matcher(data).matches();
	    
		}
}


