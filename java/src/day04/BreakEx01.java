package day04;

import java.util.Scanner;

public class BreakEx01 {

	public static void main(String[] args) {
		
		// y 를 입력하면 중지하는 코드를 작성하세요.
		
		Scanner sc = new Scanner(System.in);
			
		char ch;
		while (true) {
			System.out.print("문자 입력 : ");
			ch = sc.next().charAt(0);
			// ch 의 값이 y 이면 반복문 종료
			if (ch == 'y') {
				break;
			}
			
		}
		
	}

}
