package day06.homwork;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		/*
		UpDown 게임에 다음 기능 추가하세요.
		기록은 최대 5개
		메뉴
		1. 플레이
		2. 기록확인
		3. 종료
		메뉴 선택 : 1
		(랜덤이 35라고 가정)
		정수입력 : 50
		DOWN!
		정수 입력 : 30
		UP!
		정수 입력 : 35
		정답입니다.
		맞힌 횟수는 3회입니다.
		기록 등록됩니다.
		메뉴
		1. 플레이
		2. 기록확인
		3. 종료
		메뉴 선택 : 2
		기록확인
		1. 3회
		메뉴
		1. 플리이
		2. 기록확인
		3. 종료
		메뉴 선택 : 3
		프로그램을 종료합니다.
		*/
		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[5];
		final int MAX = 100, MIN = 1;
		int num; // 게임
		int menu; // 메뉴
		int cnt = 0; // 게임에서 시도한 수
		int gameCount = 0; // 게임수
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("4. 메뉴 선택 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1: // 플레이
				int random = (int)(Math.random() * (MAX - MIN - 1) + MIN);
				System.out.println(random);
				cnt = 0;
				do {
					System.out.println("GAME START");
					System.out.print("정수 입력 : ");
					num = sc.nextInt();
					cnt++;
					if (num > random) {
						System.out.println("Down");
					}
					else if (num < random) {
						System.out.println("UP");
					}
					else {
						System.out.println("정답입니다.");
						System.out.println("맞힌 횟수는 " + cnt + "회입니다.");
						System.out.println("기록이 저장됩니다.");
					}
				}while(num != random);
				if (gameCount < scores.length) {
					scores[gameCount++] = cnt;
				}
				else if (scores[gameCount - 1] > cnt) {
					scores[gameCount - 1] = cnt;
				}
				Arrays.sort(scores, 0, gameCount);
				break;
			case 2: // 기록확인
				for (int i = 0; i < scores.length; i++) {
					System.out.println(i+1 + ". " + scores[i] + "회");
				}
				break;
			case 3: // 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			default: // 그 외
				System.out.println("잘못된 명령입니다.");
			}
		} while(menu != 3);
		
	}

}
