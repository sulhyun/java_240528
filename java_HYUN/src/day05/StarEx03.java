package day05;

public class StarEx03 {

	public static void main(String[] args) {
		
		/*
		*을 하나씩 출력해서 다음과 같이 출력되도록 중첩 반복문을
		이용하여 작성하세요.
		(출력예제)
		    *		i = 1,	공백 = 4, 	* = 1
		   **		i = 2,	공백 = 3, 	* = 2
		  ***		i = 3,	공백 = 2, 	* = 3
		 ****		i = 4,	공백 = 1, 	* = 4
		*****		i = 5,	공백 = 0, 	* = 5
		반복 횟수 : i 는 1부터 5까지 1씩 증가
		규칙성 : * 을 i개 출력 후 엔터
			=> 반복 횟수 : j는 1부터 4 -i까지  1씩 증가
			   규칙성 : " "을 출력
			   반복문 종료 후: 없음
			   
			=> 반복 횟수 : j는 1부터 i까지  1씩 증가
			   규칙성 : *을 출력
			   반복문 종료 후: 엔터를 출력
		반복후 종료 후 : 없음
		*/
		
		// for 문 이용
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("반복문 종료 #1\n");
		
		// while 문 이용
		int i = 0, j = 0, k = 0;
		while (i < 5) {
			k = 0;
			while (k < 4 - i) {
				System.out.print(" ");
				k ++;
			}
			j = 0;
			while (j < i + 1) {
				System.out.print("*");
				j++;
			}
			i++;
			System.out.println();
		}
		System.out.println("반복문 종료 #2");
	}

}
