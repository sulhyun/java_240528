package day04;

public class WhileEx01 {

	public static void main(String[] args) {
		
		/*
		while (조건식) {
		 	실행문;
		}
		 
		초기화;
		while (조건식) {
		 	실행문;
		 	증감식;
		} 	
		*/
		
		// Hello World 를 5번 출력하는 예제
		
		/*
		반복횟수 : num 가 1부터 5까지 1씩 증가 => 초기화, 증감식, 조건식
		규칙성 : Hello World 를 콘솔에 출력 => 실행문
		반복문 종료 후 : 없음
		*/
		
		int num = 1;
		
		while (num <= 5) {
			System.out.println("Hello World");
			num++;
		}
		
	}

}
