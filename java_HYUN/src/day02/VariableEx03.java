package day02;

public class VariableEx03 {

	public static void main(String[] args) {
		
		/*
	 	* 변수 명명 규칙 (필수) *
	 	
		1. 대소문자 구분
		2. 예약어(키워드) 사용 불가
		3. 숫자로 시작 안됨	
		4. 특수문자는 _와 $만 가능
		5. 변수명 중복 선언 불가능	
		*/
		
		int num;
		// 대소문자를 구별하기 때문에 가능
		int NUM, Num, nUm, nuM;
		
		// 예약어 사용 불가능
		// int char, class, public;
		
		// 특수문자는 _와 $만 가능
		int _num, n_num, $num;
		// int n um, #num;
		
		// 숫자는 앞에 올 수 없다
		int num1;
		// int 1num;
		
		// 중복 선언 불가능 (지역변수 제외)
		// int num;
	}
	
}
