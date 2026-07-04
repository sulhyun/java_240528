package day04.homework;

public class ForEx05 {

	public static void main(String[] args) {
		
		// 1부터 10까지 짝수 합을 구하는 코드를 작성하세요
		
		int total = 0;
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) {
				total += i;
			}
		}
		System.out.println("1부터 10까지의 짝수 합 : " + total);
	}

}
