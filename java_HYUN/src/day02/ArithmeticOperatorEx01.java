package day02;

public class ArithmeticOperatorEx01 {

	public static void main(String[] args) {
		
		// 연산자 : 연산에 사용하는 기호
		// 항 : 연산에 사용하는 값 (단항, 이항, 삼황 연산자로 구분)
		
		// 대입연산자(=) : 변수에 값을 대입(저장)하는 연산자
		/*
		(중요)오른쪽에 있는 값(식 또는 변수 또는 리터럴, 상수)을 왼쪽에 저장
		이항 연산자 중 우선 순위가 가장 낮음
		(중요)왼쪽에는 변수나 상수만 올 수 있음 
		*/
		
		// 산술 연산자(+, -, /, %)
		/*
		+, -, * 는 일반 수학과 같음
		(중요) / 는 일반 수학과 다름
		정수 / 정수 => 정수
		정수 / 실수 => 실수
		실수 / 정수 => 실수
		실수 / 실수 => 실수
		% 는 나머지를 구하는 연산자
		*/
		
		// 산술 연산자 예제
		int num1 = 1, num2 =2;
		System.out.println("" + num1 + '+' + num2 + '=' + (num1 + num2));
		System.out.println("" + num1 + '-' + num2 + '=' + (num1 - num2));
		System.out.println("" + num1 + '*' + num2 + '=' + (num1 * num2));
		// 형변환 X
		System.out.println("" + num1 + '/' + num2 + '=' + (num1 / num2));
		// 형변환 O
		System.out.println("" + num1 + '/' + num2 + '=' + (num1 / (double)num2));
		System.out.println("" + num1 + '%' + num2 + '=' + (num1 % num2));
	}

}
