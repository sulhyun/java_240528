package day04;

import java.util.Scanner;

public class ForEx03 {

	public static void main(String[] args) {
		
		/*
		문자를 입력받고 입력받은 문자가 y 이면 종료하는 코드를 작성하세요.(for 문 이용)
		
		*/
		
		Scanner sc = new Scanner(System.in);

		char ch;
        for ( ; ; ) {
            System.out.print("문자 입력: ");
            ch = sc.next().charAt(0);
            if (ch == 'y') {
            	break;
            }
        }      
    }

}
