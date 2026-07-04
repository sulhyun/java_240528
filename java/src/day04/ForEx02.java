package day04;

public class ForEx02 {

	public static void main(String[] args) {
		
		/*
		구구단 2단을 출력하는 코드를 for 문을 이용하여 작성하세요.
		
		반복횟수 : i 는 1부터 9까지 1씩 증가 
		규칙성 : 2 X i = 2 * i 를 출력
		반복 종료 후 : 없음
		*/
		
		int num = 2;
		for (int i = 1; i < 10; i++) {
			int res = num * i;
			System.out.print(num + " X " + i + " = " + res + "\t");
			if (i % 3 == 0) {
				System.out.println();
			}
		}
	}

}
