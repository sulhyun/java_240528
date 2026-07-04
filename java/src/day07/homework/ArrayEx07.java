package day07.homework;

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
		int[] list = new int[5];
		final int MAX = 100, MIN = 1;
		int count = 0, gameCnt = 0;
		int menu, num;
		int random;
		do {
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
				System.out.println(random);
				count = 0;
				System.out.println("GAME START");
				do {
					System.out.print("정수 입력 : ");
					num = sc.nextInt();
					count++;
					if (num > random) {
						System.out.println("DOWN");
					}
					else if (num < random) {
						System.out.println("UP");
					}
					else {
						System.out.println("정답입니다.");
						System.out.println("맞힌 횟수는 " + count + "회입니다.");
						System.out.println("기록이 저장됩니다.");
					}
				} while (num != random);
				
				if (gameCnt < list.length) {
					list[gameCnt++] = count;
				}
				else if (list[gameCnt - 1] > count){
					list[gameCnt - 1] = count;
				}
				
				Arrays.sort(list, 0, gameCnt);
				break;
			case 2:
				System.out.println("기록확인");
				for (int i = 0; i < gameCnt; i++) {
					System.out.println(i + 1 + ". " + list[i] + "회");
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 명령입니다.");
			}
		} while(menu != 3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
