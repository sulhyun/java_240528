package day04.homework;

import java.util.Scanner;

public class ForEx03 {

	public static void main(String[] args) {
		
		/*
		구구단 2단을 출력하는 코드를 작성하세요.
		2 X 1 = 2
		2 X 2 = 4
		...
		2 X 9 = 18
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단을 입력하세요 : ");
		int dan = sc.nextInt();
		
		for (int i = 1; i < 10; i++) {
			int res = dan * i;
			System.out.println(dan + " X " + i + " = " + res);
		} 
		sc.close();
	}

}
