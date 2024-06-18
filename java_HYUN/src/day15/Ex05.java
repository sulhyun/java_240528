package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		/* 숫자 야구 게임을 구현하세요. 
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있고 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우*/
		
		// 중복되지 않은 1~9 사이의 3개의 숫자를 생성
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		final int MIN = 1, MAX = 9;
		int count = 0;
		
		while(set.size() != 3) {
			int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			set.add(random);
		}
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
		int s = 0, b = 0;
		
		System.out.println("GAME START! (1 ~ 9)");
		do {
			s = 0;
			b = 0;
			// 사용자가 숫자 3개를 중복되지 않게 1~9 사이의 값을 입력
			System.out.print("3자리 정수 입력 : ");
			for (int i = 0; i < 3; i++) {
				user.add(i, sc.nextInt());
			}
			
			// 입력한 값과 랜덤 값을 이용하여 결과를 출력
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (list.get(i) == user.get(j)) {
						if (i == j) {
							s++;
						}
						else {
							b++;
						}
					}
				}
			}
			System.out.println(user);
			
			if (s != 0) {
				System.out.print(s + "S");
			}
			if (b != 0) {
				System.out.print(b + "B");
			}
			if (s == 0 && b == 0) {
				System.out.print("O");
			}
			System.out.println();
			user.clear();
			
		} while (s != 3);
		System.out.println("정답입니다.");
	}

}
