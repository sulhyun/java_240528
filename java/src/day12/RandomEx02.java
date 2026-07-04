package day12;

import java.util.Random;

public class RandomEx02 {

	public static void main(String[] args) {
		
		/* min ~ max 사이의 랜덤한 수를 만드는 코드를 작성하세요.
		 * int r = (int)(Math.random()*(max - min + 1) + min */
			
		Random random = new Random();
		
		int max = 10, min = 1;
		
		for (int i = 0; i < 20; i++) {
			int num = random.nextInt(max - min + 1) + min;
			System.out.print(num + " ");
		}
		
	}

}
