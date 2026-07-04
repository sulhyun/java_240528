package day04;

public class WhileEx04 {

	public static void main(String[] args) {
		
		/*
		1부터 10까지 합을 구하는 코드를 작성하세요
		
		반복횟수 : i 는 1부터 10까지 1씩 증가
		규칙성 : sum = sum + i
		반복문 종료 후 : sum 을 출력
		*/
		
		int i = 1;
		int sum = 0;
		
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("총합 : " + sum);
		
	}

}
