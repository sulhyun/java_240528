package day04.homework;

public class ForEx06 {

	public static void main(String[] args) {
		
		/*
		12의 약수를 출력하는 코드를 작성하세요.
		약수는 나누어서 나머지가 0이 되게 하는 수
		12의 약수 : 1, 2, 3, 4, 6, 12
		*/
		
		int num =  12;
		System.out.print("12의 약수 : ");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + (i != num ? ", " : "\n"));
			}
		}
		System.out.println();
	}
	
}
