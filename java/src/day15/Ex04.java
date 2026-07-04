package day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		/* 1 ~ 45 사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고
		 * 사용자가 번호를 6개를 입력해서 몇등인지 맞추는 로또 예제 
		 * 1등 : 번호 6개가 일치
		 * 2등 : 번호 5개와 보너스 번호 일치
		 * 3등 : 번호 5개가 일치
		 * 4등 : 번호 4개가 일치
		 * 5등 : 번호 3개가 일치
		 * 나머지 꽝 */
		
		HashSet<Integer> lotto = new HashSet<Integer>();
		HashSet<Integer> user = new HashSet<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		final int MAX_CNT = 6;
		final int MIN = 1, MAX = 45;
		int bonus;
		
		// 로또 번호와 보너스 번호를 생성
		while(lotto.size() != MAX_CNT) {
			int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			lotto.add(random);
		}
		do {
			bonus = (int)(Math.random()*(MAX - MIN +1) + MIN);
		}while(lotto.contains(bonus));
		
		
		System.out.println(lotto);
		System.out.println(bonus);
		
		// 사용자가 6개의 번호를 입력
		System.out.print("로또 번호 입력(6자리) : ");
		while(user.size() < 6) {
			user.add(sc.nextInt());
		}
		
		System.out.println(user);
		
		//입력한 번호를 이용하여 당첨 등수를 출력
		int count = 0;
		for (Integer integer : lotto) {
			if(user.contains(integer)) {
				count++;
			}
		}
		
		switch(count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			if(user.contains(bonus)) {
				System.out.println("2등");
			}
			else {
				System.out.println("3등");
			}
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;
		default:
			System.out.println("꽝");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
