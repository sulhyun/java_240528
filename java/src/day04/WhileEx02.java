package day04;

public class WhileEx02 {

	public static void main(String[] args) {
		
		/* 
		1부터 5까지 콘솔에 출력하는 코드를 작성하세요.
		반복횟수 : num 가 1부터 5까지 1씩 증가
		규칙성 : num 를 출력
		반복문 종료 후 : 없음 
		*/
		
		int num = 1;
		
		while (num <= 5) {
			System.out.print(num + " ");
			num++;
		}
		System.out.println();
		
		/*
		10부터 1까지 콘솔에 출력하는 코드를 작성하세요.
		반복횟수 : num 이 10부터 1까지 1씩 감소
		규칙성 : num 를 출력
		반복문 종료 후 : 없음
		
		*/
		
		num = 10;
		
		while (num >= 1) {
			System.out.print(num + " ");
			num--;
		}
		System.out.println();
		
	}

}
