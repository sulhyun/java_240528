package day04.homework;

import java.util.Scanner;

public class UpDownGame03 {

	public static void main(String[] args) {
		
		/*
		1 ~ 100 사이의 랜덤한 수를 생성하여 해당 숫자를 맞추는 게임을
		작성하세요. (for 문 이용)
		예 (랜덤한 수가 30)
		정수 입력 : 50
		DOWN!
		정수 입력 : 20
		UP!
		정수 입력 : 25
		UP!
		정수 입력 : 30
		정답입니다!
		*/
		
		final int MIN = 1, MAX = 100;
		int random = (int)(Math.random() * (MAX - MIN + 1) + MIN );
		int cnt = 0;
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("GAME START!! (1 ~ 100)");
		do {
			System.out.print("정수 입력 : ");
			num = sc.nextInt();
			cnt++;
			if (num == random) {
				System.out.println("정답입니다.");
				System.out.println(cnt + "번째만에 맞추셨습니다.");
			} else if (num > random) {
				System.out.println("DOWN!");
			} else if (num < random) {
				System.out.println("UP!");
			} else {
				System.out.println("잘못된 값입니다.");
			}
		}while(num != random);
		sc.close();
	}

}
