package day01;

public class VariavleEx01 {

	public static void main(String[] args) {
		
		// 문자형 변수 ch1를 선언
		char ch1;
		
		// 문자형 변수 ch2를 선언하고 A로 초기화
		char ch2 = 'A';
		
		// 문자형 변수 ch3, ch4를 선언
		char ch3, ch4; // 같은 자료형인 경우 ,를 통해 동시 선언 가능
		
		// 문자형 변수 ch5를 선언하고 +로 초기화
		// 문자형 변수 ch6을 선언하고 \n 으로 초기화
		char ch5 = '+', ch6 = '\n';
		
		System.out.println(ch2);
		System.out.println(ch6);
		System.out.println(ch5);
		
		// 오버플로우 : 범위가 최댓값을 넘어가서 최솟값으로 넘어가는것
		// 언더플로우 : 범위가 최솟값을 넘어가서 최댓값으로 넘어가는것
		
		// 정수값이 int 형으로 표현되지 않으면 반드시 접미사 L을 붙여야함
		long num1 = 1234567890123L;
		
		System.out.println(num1);
		
		/*
		양수의 비트를 음수로 만드는 법
		5의 2진수 => 0000 0101
		5의 1의 보수 => 1111 1010
		끝자리 1더해주기(2의보수) => 1111 1011 : -5
		*/
		
		// 정수 리터럴은 기본이 int
		// 실수 리터럴은 기본이 double
		
		// 실수(근사치이기 때문에 항상 오차 발생)
		// 3.14는 double 형이기 때문에 반드시 접미사 F를 붙여야함
		float num2 = 3.14F;
		double num3 = 3.14;
		
		System.out.println(num2);
		System.out.println(num3);
		
		// 논리형
		boolean isEven = true;
		boolean infinitySpace = false;
		
		System.out.println(isEven);
		System.out.println(infinitySpace);
	}	

}
