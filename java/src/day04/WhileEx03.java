package day04;

import java.util.Scanner;

public class WhileEx03 {

	public static void main(String[] args) {
		
		/*
		구구단 2단을 출력하는 코드를 작성하세요.
		2 X 1 = 2
		2 X 2 = 4
		...
		2 X 9 = 18
		반복횟수 : num 는 1부터 9까지 1씩 증가
		규칙성 : 2 X num = (2 * num)를 출력
		반목문 종료 후 : 없음
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단을 입력하세요 : ");
		int dan = sc.nextInt();
		int num = 1;
		
		while (num <= 9) {
			int res = dan * num;
			System.out.print(dan + " X " + num + " = "
						+ res + "\t");
			
			if (num % 3 == 0) {
				System.out.println();			
			}
			num++;
		}
		
	}

}
