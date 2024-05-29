package day02;

public class CastingEx01 {

	public static void main(String[] args) {

		/*
		형변환
		- 값을 다른 자료형(변수타입)으로 변환하는것
		- boolean 을 제외한 기본형은 변환 가능
		- 자동 자료형 변환(묵시적) [작은 자료형 -> 큰 자료형]
		- 강제(명시적) 자료형 변환 [큰 자료형 -> 작은 자료형]
		*/
		
		// 자동 자료형 변환이 동작 (정수 -> 실수)
		double num1 = 3; // O
		
		// 자동 자료형 변환이 동작 (int -> long)
		long num2 = 3; // O
		
		// 자동 자료형 변환이 동작X (int -> int)
		int num3 = 3; // X
		
		// 자동 자료형 변환이 동작 (int -> long)
		long num4 = num3; // O
		
		// 명시적 자료형 변환 동작 (실수 -> 정수)
		int num5 = (int)3.14;
		System.out.println(num5);
		
		// 명시적 자료형 변환 동작 (int -> byte)
		// 원래의 값과 결과가 같음
		byte num6 = (byte)num5;
		System.out.println(num6);
		
		// 원래의 값과 결과가 다름
		byte num7 = (byte)123123;
		System.out.println(num7);
		
		// 자동 자료 형변환이 일어나지만 명시적 자료형변환이 필요한 경우
		double res = 1 / 2; // 나누기에 결과인 0이 자동형변환으로 0.0으로 변환
		System.out.println(res);
		
		res = 1 / (double)2; // 2를 명시적 자료형변화으로 변환하여 1/2.0을 계산해서 0.5를 저장
		System.out.println(res);
	}

}
