package day04.homework;

public class ForEx08 {

	public static void main(String[] args) {
		
		/*
		두 정수 8과 12의 최대 공약수를 구하는 코드를 작성하세요.
		공약수 : 공통으로 있는 약수
		최대 공약수 : 공약수 중 가장 큰 공약수
		8 : 1, 2, 4, 8
		12 : 1, 2, 3, 4, 6, 12
		8과 12의 공약수 : 1, 2, 4
		8과 12의 최대 공약수 : 4
		*/
		
		int num1 = 8, num2 = 12;
		int result = 1;
		
		for (int i = 1; i < 9; i++) {
			if (num2 % i == 0) {
				if (num1 % i == 0) { 
					result = i;
				}
			}
		}
		System.out.println(num1 + ", " + num2 +
					"의 최대공약수 : " + result);
		
	}

}
