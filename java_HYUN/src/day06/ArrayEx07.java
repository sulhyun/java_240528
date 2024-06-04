package day06;

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
		final int MAX = 100, MIN = 1;
		int cnt = 0; 
		int num = 0;
		int gameIndex = 0;
		int[] score = new int[5];
		for(; ;) {
			int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			int choic = sc.nextInt();
			
			if(choic == 1) {
				System.out.println("GAME START!!");
				cnt = 0;
				do {
					System.out.print("정수 입력 : ");
					num = sc.nextInt();
					cnt++;
					if (num == random) {
						System.out.println("정답입니다.");
						System.out.println(cnt + "번만에 맞추셨습니다.");
						System.out.println("기록이 저장됩니다.");
					}
					else if (num > random) {
						System.out.println("DOWN!");
					}
					else if (num < random) {
						System.out.println("UP!");
					}
				} while (num != random);
				
				if (gameIndex < score.length) {
					score[gameIndex++] = cnt;
		
				}
				else if (score[gameIndex - 1] > cnt) {
					score[gameIndex - 1] = cnt;
				}
				// 기록 정렬
				// Arrays.sort를 이용하여 0번지부터 gameIndex 번지 전까지 정렬
				// 0번지 포함, gameIndex 번지는 포함을 안하고 앞 번지까지
				Arrays.sort(score, 0, gameIndex);
			}
			else if (choic == 2) {
				
				for (int i = 0; i < gameIndex; i++) {
					System.out.println(i+1 + "위 " + score[i] + "회");
				} 
				
			}
			else if (choic == 3) {
					System.out.println("프로그램을 종료하겠습니다.");
				break;
			}
			else {
				System.out.println("잘못된 요청입니다.");
			}
			
		}	
		
	}

}
