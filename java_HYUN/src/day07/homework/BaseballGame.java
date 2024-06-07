package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

/*
숫자 야구 게임을 구현하세요
규칙
- 중복되지 않은 1~9 사이의 랜덤한 수를 생성
- 이 세 수를 맞추는 게임
- 스트라이크 : 해당 숫자가 있고, 위치도 같은 겨우
- 볼 : 숫자가 있지만 위치가 다른 경우
- 아웃 : 일치하는 숫자가 하나도 없는 경우
예시
(3 9 7)
입력 : 1 2 3
1B
입력 : 5 6 7
1S
입력 : 4 5 6
O
입력 : 3 7 9
1S 2B
입력 : 3 9 7
3S
정답입니다.
*/

public class BaseballGame {

	public static void main(String[] args) {
		
		
		int[] list = new int[3];
		final int MAX = 9, MIN = 1;
		int count = 0;
		int i;
		while (count < 3) {
		// 랜덤한 수를 변수에 저장하고
		int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			// 랜덤한 수의 중복이 있는 확인하고
			for (i = 0; i < count; i++) {
				if(list[i] == random) {
					break;
				}
			}
		// 중복이 아니라면 배열에 저장하고
			if (i == count) {
				list[count] = random;
				count++;
			}
		}
		System.out.println(Arrays.toString(list));
		
		Scanner sc = new Scanner(System.in);
		int[] user = new int[3];
		int s = 0, b = 0;
		
		System.out.println("GAME START! (1 ~ 9)");
		do {
			s = 0;
			b = 0;
		
			System.out.print("정수입력  : ");
			for (int j = 0; j < user.length; j++) {
				user[j] = sc.nextInt();
			}
			
			for (int j = 0; j < user.length; j++) {
				for (int k = 0; k < user.length; k++) {
					if(list[j] == user[k]) {
						if(j == k) {
							s++;
						}
						else {
							b++;
						}
					}
				}

			}
			
			if (s > 0) {
				System.out.print(s + "S");
			}
			if (b > 0) {
				System.out.println(b + "B");
			}
			if (s == 0 && b == 0) {
				System.out.println("O");
			}
			System.out.println();
			
		} while (s != 3);
		System.out.println("정답입니다.");
		System.out.println(Arrays.toString(user));
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
