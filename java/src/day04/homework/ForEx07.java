package day04.homework;

public class ForEx07 {

	public static void main(String[] args) {
		
		/*
		4가 소수인지 아닌지 판별하는 코드를 작성하세요.
		소수는 약수가 1과 자기자신인 수를 소수라고 함
		1 : 소수아님
		2 : 소수
		3 : 소수
		4 : 소수가 아님
		*/
		
		int num = 5;
		int cnt = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				cnt++;
			}
		}
		if(cnt == 2) {
			System.out.println(num + "  : 소수");
		}
		else {
			System.out.println(num + " : 소수가 아님");
		}
		
	}

}
