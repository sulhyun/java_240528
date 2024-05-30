package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		
		/*
		월을 입력받아 입력받은 월의 계절을 출력하세요.
		*/
		
		// Scanner 클래스
		Scanner sc = new Scanner(System.in);
		
		// 월을 물어보는 출력문
		System.out.print("월을 입력하세요 : ");
		// 월을 입력받는 변수 month 선언
		int month = sc.nextInt();
		
		boolean spring = month == 3 || month == 4 || month == 5;
		boolean summer = month == 6 || month == 7 || month == 8;
		boolean autumn = month == 9 || month == 10 || month == 11;
		boolean winter = month == 12 || month == 1 || month == 2;
		
		if (spring) {
			System.out.println(month + "월은 봄입니다.");
		} else if (summer) {
			System.out.println(month + "월은 여름입니다.");
		} else if (autumn) {
			System.out.println(month + "월은 가을입니다.");
		} else if (winter) {
			System.out.println(month + "월은 겨울입니다.");
		} else {
			System.out.println("잘못된 월 입니다.");
		}
		
	}

}
