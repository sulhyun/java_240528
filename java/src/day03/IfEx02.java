package day03;

import java.util.Scanner;

public class IfEx02 {

	public static void main(String[] args) {
		
		// if else 문을 이용하여 홀짝 판별 예제
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		// num 가 짝수이면 짝수라고 출력
		if (num % 2 == 0) {
			System.out.println("짝수");
		// 아니면 홀수라고 출력
		// else 는 현 위치에서 위에 있는 연결된 조건문들이 모두 거짓이면 실행
		} else {
			System.out.println("홀수");
		}
	}

}
