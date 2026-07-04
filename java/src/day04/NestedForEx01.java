package day04;

public class NestedForEx01 {

	public static void main(String[] args) {
		
		/*
		구구단 2~9단을 출력하는 코드를 작성하세요.
		
		반복횟수 : i 를 2부터 9까지 1씩 증가
		규칙성 : i 단 출력하는 코드
		반복문 종료 후 : 없음
		*/
		
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "단");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + " X " + j + 
						" = " + i * j + "\t");
				if (j % 3 == 0) {
					System.out.println();
				}
				
			}
			System.out.println();
		}
		
	}

}
