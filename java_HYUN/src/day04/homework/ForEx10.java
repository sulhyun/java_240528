package day04.homework;

import java.util.Scanner;

public class ForEx10 {

	public static void main(String[] args) {
		
		/*
		반복문을 이용하여 문자를 입력받고 입력받은 문자가 y 이면 반복문을 
		종료하는 코드를 작성하세요. 
		*/
		
		Scanner sc = new Scanner(System.in);
		
		char ch = ' ';
		
		for (; ch != 'y';) {
			System.out.print("문자 입력 : ");
			ch = sc.next().charAt(0);
		}
		sc.close();
	}

}
