package day24.exam;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		/* 문자열을 입력받아 exit가 아니면 입력한 문자열 출력하고, exit이면
		 * 종료하는 코드를 작성하려고 한다.
		 * 원인 : 
		 * 1. res 가 false 이어서 한번도 실행이 안됨
		 * 2. 문자열을 == 로 비교함
		 * 3. continue (while 문에서 조건식으로 이동)
		 * 해결방안 : 
		 * 1. res 를 true 로 수정 
		 * 2. == -> equals 
		 * 3. continue -> break */
				
		Scanner scan = new Scanner(System.in);
		boolean res = true;
		while(res) {
			System.out.print("문자열 입력 : ");
			String str = scan.next();
			if(str.equals("exit")) {
				break;
			}
			System.out.println(str);
		}
	}

}
