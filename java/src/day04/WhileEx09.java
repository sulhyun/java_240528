package day04;

public class WhileEx09 {

	public static void main(String[] args) {
		
		/*
		a 부터 z 까지 출력하는 코드를 작성하세요.
		
		반복횟수 : i 는 0 부터 25까지 1씩 증가
		규칙성 : 'a' + i 를 문자로 출력
		반복문 종료 후 : 없음
		*/
		
		/*
		반복횟수 : ch 는 'a' 부터 'z' 까지 1씩 증가
		규칙성 : ch 를 출력
		반복문 종료 후 : 없음
		 */
		
		char ch = 'a';
		int i = 0;
		int num = 25;
		while (i <= num) {
			System.out.print((char)(ch + i) + " ");
			i++;
		}
		System.out.println();
		
		ch = 'a';
		while (ch <= 'z') {
			System.out.print(ch + " ");
			ch++;
		}
		System.out.println();
	}

}
