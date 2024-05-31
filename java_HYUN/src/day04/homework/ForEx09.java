package day04.homework;

public class ForEx09 {

	public static void main(String[] args) {
		
		/*
		a 부터 z 까지 출력하는 코드를 작성하세요.
		
		반복횟수 : i 는 0 부터 25까지 1씩 증가
		규칙성 : 'a' + i 를 문자로 출력
		반복문 종료 후 : 없음
		*/
		
		char ch = 'a';
		for (int i = 0; i < 26; i++) {
			ch = (char)('a' + i);
			System.out.print(ch + " ");
		}
		System.out.println();
		
		/*
		반복횟수 : ch 는 'a' 부터 'z' 까지 1씩 증가
		규칙성 : ch 를 출력
		반복문 종료 후 : 없음
		 */
		
		for (ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch + " ");
		}
		System.out.println();	
	}

}
