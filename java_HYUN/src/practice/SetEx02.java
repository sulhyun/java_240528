package practice;

import java.util.HashSet;
import java.util.Scanner;

public class SetEx02 {

	public static void main(String[] args) {
		
		/* 1 ~ 45 사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고
		 * 사용자가 번호를 6개를 입력해서 몇등인지 맞추는 로또 예제 
		 * 1등 : 번호 6개가 일치
		 * 2등 : 번호 5개와 보너스 번호 일치
		 * 3등 : 번호 5개가 일치
		 * 4등 : 번호 4개가 일치
		 * 5등 : 번호 3개가 일치
		 * 나머지 꽝 */
		
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> lotto = new HashSet<Integer>();
		HashSet<Integer> user = new HashSet<Integer>();
		
		int min = 1, max = 45;
		int bonus;
		
		while(lotto.size() != 6) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			lotto.add(random);
		}
		
		do {
			bonus = (int)(Math.random() * (max - min + 1) + min);
		}
		while(lotto.contains(bonus));
		
		System.out.println(lotto + " " + bonus);
		
		System.out.print("로또 번호 입력 : ");
		while(user.size() != 6) {
			user.add(sc.nextInt());
		}
		
		int count = 0;
		for (Integer integer : lotto) {
			if(user.contains(integer)) {
				count++;
			}
		}
		
		boolean isBonus = false;
		
		if(user.contains(bonus)) {
			isBonus = true;
		}
		
		switch(count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			if (isBonus) {
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
