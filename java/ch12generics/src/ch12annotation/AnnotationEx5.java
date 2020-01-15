package ch12annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@TestInfo(testBy = "aaa", 
testDate = @DataTime(yymmdd = "20191104",hhmmss = "122705"))
public class AnnotationEx5 {
	
	@DataTime(yymmdd = "20191104",hhmmss = "121800")
	public static void main(String[] args) {
	//테스트 날짜와 시간 어노테이션 테스트
		
		Class<AnnotationEx5> c = AnnotationEx5.class;
		TestInfo ti = c.getAnnotation(TestInfo.class);
		System.out.println(ti.count());
		System.out.println(ti.testDate());
		
	}
}// end of AnnotationEx5 class
// 테스트 타입 지정  -> enum
enum TestType{FIRST, FINAL}

// 테스트 날짜와 시간 -> annotation
@Retention(RetentionPolicy.RUNTIME)
@interface DataTime{
	String yymmdd();
	String hhmmss();
}
// 이미 작성되어진 어노테이션을 타입으로 할 수 있다.

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
	int count() default 1;
	String testBy();
	DataTime testDate();
		
}
