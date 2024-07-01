package day24.exam;

public class Ex01 {

	public static void main(String[] args) {
		
		int num1 = 4;
		double num2 = num1; // 인트 -> 더블 (묵시적 형변환)
		System.out.println(num2); // 4.0
		
		/* 에러발생
		 * 원인 : 실수를 정수로 자동 자료형변환을 하려 했기 때문에
		 * 해결 방법 : 명시적 형변환을 하던지 실수형 변수에 저장 */
		
		int num3 = (int)num2; // 더블 -> 인트 (명시적 형변환)
		System.out.println(num3);
	}

}
