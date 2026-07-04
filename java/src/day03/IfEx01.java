package day03;

import java.util.Scanner;

public class IfEx01 {

	public static void main(String[] args) {
		
		// if 문을 이용한 홀짝 판별 예제
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		// num 가 짝수이면 짝수라고 출력
		if (num % 2 == 0) {
			System.out.println("짝수");
		}
		// num 가 홀수이면 홀수라고 출력
		if (num % 2 != 0) {
			System.out.println("홀수");
		}
		
	}

}
