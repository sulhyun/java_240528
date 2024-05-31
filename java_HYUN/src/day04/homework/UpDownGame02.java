package day04.homework;

import java.util.Scanner;

public class UpDownGame02 {

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
		
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		// System.out.println("랜덤한 수 : " + random);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("GAME START!! (1 ~ 100)");
		for (int i = 1;; i++) {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			if (num == random) {
				System.out.println("정답입니다!");
				System.out.println(i + "번째 시도만에 맞추셨습니다.");
				break;
			} else if (num > random) {
				System.out.println("DOWN!");
			} else if (num < random) {
				System.out.println("UP!");
			} else {
				System.out.println("잘못된 값입니다.");
			}
		}
		sc.close();
		
	}

}
