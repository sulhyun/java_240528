package day04;

import java.util.Scanner;

public class WhileEx10 {

	public static void main(String[] args) {
		
		/*
		반복문을 이용하여 문자를 입력받고 입력받은 문자가 y 이면 반복문을 
		종료하는 코드를 작성하세요. 
		
		반복횟수 : ch 는 y 가 아닌 문자로 시작해서 y 가 아니면 반복
		규칙성 : 안내문구 출력 후 ch 에 Scanner 를 이용하여 문자를 저장
		반복문 종료 후 : 없음
		*/
		
		Scanner sc = new Scanner(System.in);
		
		char ch = ' ';
		while(ch != 'y') {
			System.out.print("문자를 입력하세요 : ");
			ch = sc.next().charAt(0);
		}
		
	}

}
