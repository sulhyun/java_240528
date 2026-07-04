package day03;

import java.util.Scanner;

public class IfEx03 {

	public static void main(String[] args) {
		
		// else if 예제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		// num 가 0이면 0이라고 출력하고
		if (num == 0) {
			System.out.println(0);
		// num 가 0이 아니고 양수이면 양수라고 출력하고	
		} else if (num > 0) {
			System.out.println(num + "는 양수");
		// num 가 0과 양수가 아니면 음수라고 출력하세요.	
		} else {
			System.out.println(num + "는 음수");
		}
		
	}

}
