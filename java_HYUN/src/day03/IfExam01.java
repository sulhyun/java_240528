package day03;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) {
		/*
		나이를 입력받아 나이가 19세 이상이면 성인을 출력하고, 19세 미만이면
		미성년자로 출력하는 코드를 작성하세요.
		*/
		
		// Scanner 클래스 
		Scanner sc = new Scanner(System.in);
		
		// 나이를 물어보는 출력문
		System.out.print("나이를 입력하세요 : ");
		
		// 나이를 입력받는 변수 age 선언
		int age = sc.nextInt();
		
		// 19세 이상이면 성인을 출력
		if (age >= 19) {
			System.out.println(age + "세는 성인입니다.");
		// 아니면 미성년자를 출력	
		} else {
			System.out.println(age + "세는 미성년자입니다.");
		}
		
	}

}
