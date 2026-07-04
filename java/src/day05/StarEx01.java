package day05;

public class StarEx01 {

	public static void main(String[] args) {
		
		/*
		*을 하나씩 출력해서 다음과 같이 출력되도록 중첩 반복문을
		이용하여 작성하세요.
		(출력예제)
		*****
		*****
		*****
		*****
		*****
		반복 횟수 : i 는 1부터 5까지 1씩 증가
		규칙성 : *****을 출력
			=> 반복 횟수 : j는 1부터 5까지 1씩 증가
			   규칙성 : *을 출력(한 줄로)
			   반복문 종료 후: 엔터를 출력
		반복후 종료 후 : 없음
		*/
		
		// for 문 이용
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("반복문 종료 #1\n");
		
		// while 문 이용
		int i = 0, j = 0;
		while (i < 5) {
			j = 0;
			while (j < 5) {
				System.out.print("*");
				j++;
			}
			i++;
			System.out.println();
		}
		System.out.println("반복문 종료 #2");
	}

}
