package day03;

import java.util.Scanner;

public class IfExam03 {

	public static void main(String[] args) {
		
		/*
		산술 연산자와 두 정수를 입력받아 산술 연산자에 맞는 연산 결과를
		출력하는 코드를 작성하세요.
		*/
		
		// Scanner 클래스 생성
		Scanner sc = new Scanner(System.in);
		// 정수와 산술 연산자를 물어보는 출력문
		System.out.print("두 정수와 산술 연산자를 입력하세요 : ");
		// 정수와 산술 연산자를 입력하는 입력문
		int num1 = sc.nextInt();
		char sign = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		if (sign == '+') {
			System.out.println(num1 + " + " + num2 + " = "
					+ (num1 + num2));
		} else if (sign == '-') {
			System.out.println(num1 + " - " + num2 + " = "
					+ (num1 - num2));
		} else if (sign == '*') {
			System.out.println(num1 + " * " + num2 + " = "
					+ (num1 * num2));
		} else if (sign == '/') {
			System.out.println(num1 + " / " + num2 + " = "
					+ (num1 / (double)num2));
		} else if (sign == '%') {
			System.out.println(num1 + " % " + num2 + " = "
					+ (num1 % num2));
		} else {
			System.out.println("잘못된 기호입니다.");
		}
		
	}

}
