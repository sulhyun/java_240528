package day03;

import java.util.Scanner;

public class SwitchEx03 {

	public static void main(String[] args) {
		
		/*
		산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산
		결과를 출력하는 코드를 작성하세요.(switch 문으로)
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 정수와 산술 연산자를 입력하세요 : ");
		
		int num1 = sc.nextInt();
		char sign = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		switch (sign) {
		case '+':
			System.out.println("" + num1 + " " + sign + " " + num2 + " = "
					+ (num1 + num2));
			break;
		case '-':
			System.out.println(num1 + " - " + num2 + " = "
					+ (num1 - num2));
			break;
		case '*':
			System.out.println(num1 + " * " + num2 + " = "
					+ (num1 * num2));
			break;
		case '/':
			System.out.println(num1 + " / " + num2 + " = "
					+ (num1 / (double)num2));
			break;
		case '%':
			System.out.println(num1 + " % " + num2 + " = "
					+ (num1 % num2));
			break;
		default:
			System.out.println("잘못된 기호 입니다.");
		}
		
	}

}
