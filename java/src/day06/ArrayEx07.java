package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[5]; 
		final int MAX = 100, MIN = 1;
		int gameCnt = 0;
		int num, menu;
		do {
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1: // 플레이
				int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
				int cnt = 0;
				System.out.println("GAME START");
				do {
					System.out.print("정수 입력 : ");
					num = sc.nextInt();
					cnt++;
					if (num > random) {
						System.out.println("DOWN");
					}
					else if (num < random) {
						System.out.println("UP");
					}
					else {
						System.out.println("정답입니다.");
						System.out.println("맞힌 횟수는 " + cnt + "회입니다.");
						System.out.println("기록이 저장됩니다.");
					}
				} while (num != random);
				
				// 배열에 카운트를 저장하는 코드
				// 인덱스 0, 1, 2, 3, 4 까지 초기화하고 else if 문으로 넘어감
				if (gameCnt < scores.length) {
					scores[gameCnt++] = cnt;
				}
				// 
				else if (scores[gameCnt - 1] > cnt) {
					scores[gameCnt - 1] = cnt;
				}
				// 배열을 오름차순으로 바꿔주는 코드
				Arrays.sort(scores, 0, gameCnt);
				
				break;
			case 2: // 기록확인
				for (int i = 0; i < scores.length; i++) {
					System.out.println(i + 1 + ". " + scores[i] + "회");
				}
				break;
			case 3: // 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 명령입니다.");
			}
		} while(menu != 3);
		sc.close();
	}

}
