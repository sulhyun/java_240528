package day03;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		
		/*
		정수를 입력 받아 2, 3, 6의 배수인지 아닌지 
		판별하는 코드를 작성하세요. 
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		// 방법 1
		if (num % 2 == 0) {
			if (num % 3 == 0) {
				System.out.println("6의 배수입니다.");
			} else {
				System.out.println("2의 배수입니다.");
			}
		} else if (num % 3 == 0) {
			System.out.println("3의 배수입니다.");
		} else {
			System.out.println("2, 3, 6 배수가 아닙니다.");
		}
		
		// 방법 2
		if(num % 2 == 0 && num % 3 != 0) {
			System.out.println("2의 배수입니다.");
		} else if (num % 3 == 0 && num % 2 != 0) {
			System.out.println("3의 배수입니다.");
		} else if (num % 6 == 0) {
			System.out.println("6의 배수입니다.");
		} else {
			System.out.println("2, 3, 6의 배수가 아닙니다.");
		}
			
		
	}

}
