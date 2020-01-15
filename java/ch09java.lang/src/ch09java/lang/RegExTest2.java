package ch09java.lang;

public class RegExTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numReg = "^[0-9]+$";
		String input = "123ads";
		if(RegExUtil.matchRegEx(numReg, input))
			System.out.println("숫자입니다.");
		else System.out.println("숫자가 아닙니다.");
		
		// 이메일인지 알아내는 패턴 문자열
		String emailpattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		String email = "123ads@dfdfdf.com";
		if(RegExUtil.matchRegEx(emailpattern, email))
			System.out.println("이메일 형식에 맞습니다.");
		else System.out.println("이메일 형식에 맞지 않습니다.");
		
		// 핸드폰 번호인지 알아내는 패턴 문자열 
		String hppattern = "^01(?:0|1[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
		String hp = "123ads";
		if(RegExUtil.matchRegEx(hppattern, hp))
			System.out.println("핸드폰 형식에 맞습니다.");
		else System.out.println("핸드폰 형식에 맞지 않습니다.");
		
		// 생년 월일 인지 알아 내는 패턴 문자열 
		String birthpattern = "^\\d{2}(0[1-9]|1[0-2](0[1-9][12][0-9][3][01])";
		String birth = "asdasd123";
		if(RegExUtil.matchRegEx(birthpattern, birth))
			System.out.println("생년월일 형식에 맞습니다.");
		else System.out.println("생년 월일형식에 맞지 않습니다.");
		
		// 아이디 - 맨앞자리는 영문자이여야 한다. 그리고 뒤에는 영문자와 숫자만 사용 가능하다. 
		String idpattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
		String id = "123ads";
		if(RegExUtil.matchRegEx(idpattern, id))
			System.out.println("아이디 형식에 맞습니다.");
		else System.out.println("아이디 형식에 맞지 않습니다.");
		
		//       길이가 4자 부터 20자 까지만 가능하다. 
		// 비밀번호 - 길이가 4자 이상이고 아무 글자나 사용가능하다.  
		String pwpattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{4,20}$"; 
		String pw = "123ads";
		if(RegExUtil.matchRegEx(pwpattern, pw))
			System.out.println("비밀 번호 형식에 맞습니다.");
		else System.out.println("비밀 번호 형식에 맞지 않습니다.");
	
	}

}
