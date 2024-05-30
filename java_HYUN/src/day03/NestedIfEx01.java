package day03;

import java.util.Scanner;

public class NestedIfEx01 {

	public static void main(String[] args) {
		
		//6의 배수를 중첩 if 문을 이용하여 작성하는 예제
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		// if 문
		if (num % 2 == 0 && num % 3 == 0) {
			System.out.println("6의 배수입니다.");
		} else {
			System.out.println("6의 배수가 아닙니다.");
		}
		
		// 중첩 if 문
		if (num % 2 == 0) {
			if (num % 3 == 0) {
				System.out.println("6의 배수입니다.");
			} else {
				System.out.println("6의 배수가 아닙니다.");
			}
		} else {
			System.out.println("6의 배수가 아닙니다.");
		}
		
	}

}
