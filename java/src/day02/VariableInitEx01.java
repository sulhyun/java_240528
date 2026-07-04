package day02;

public class VariableInitEx01 {

	public static void main(String[] args) {

		// 지역 변수 : 사용되기 전 반드시 초기화
		
		int num;
		
		// num 을 초기화 하지 않아서 에러 발생
		// System.out.println(num);
		
		num = 0;
		
		// num 을 초기화 해서 에러 발생하지 않음
		System.out.println(num);
	}

}
