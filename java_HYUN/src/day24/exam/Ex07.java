package day24.exam;

public class Ex07 {

	public static void main(String[] args) {
		
		/* 1부터 10까지의 합을 구하려고 했다.
		 * 원인 : 세미콜론 
		 * 해결방법 : 세미콜론 제거*/
		
		int i;
		int sum = 0;
		for(i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1부터 10까지의 합 : " + sum);
	}

}
