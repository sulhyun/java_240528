package day04;

public class NestedForEx02 {

	public static void main(String[] args) {
		
		/*
		num 가 소수인지 아닌지 판별하는 코드를 이용하여 100이하의 소수를
		출력하는 코드를 작성하세요.
		
		반복횟수 : num 는 2부터 100까지 1씩 증가
		규칙성 : num 가 소수인지 아닌지 판별하는 코드를 활용해서 소수이면 
		num 를 출력, 아니면 아무것도 안함
		반복문 종료 후 : 없음
		*/
		
		int num, i;
		int count;
		for (num = 2; num <= 100; num++) {
			count = 0;
			for (i = 1; i <= num; i++) {
				if (num % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.print(num + " ");
			}
			
		}

	}

}
