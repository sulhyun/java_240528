package day24.exam;

public class Ex02 {

	public static void main(String[] args) {
		
		int num1 = 1, num2 = 2;
		
		double res = (double)num1 / num2;
		
		/* 1 / 2 = 0.5가 출력되지 않음
		 * 원인 : 정수 나누기 정수 => 정수이기 때문에 0을 실수로 저장해봐야 0.0이 됨
		 * 해결 방법 : num1이나 num2를 실수로 저료형변화을 해야됨 */
		
		System.out.println(num1 + " / " + num2 + " = " + res);
	}

}
