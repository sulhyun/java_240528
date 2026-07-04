package day04;

public class VariableEx06 {

	public static void main(String[] args) {
		
		// 정수를 활용한 문자 출력 예제
		// 알바벳은 아스키 코드에 의해 각 정수에 맞는 알파벳이 지정되어 있음.
		// 알파벳에 맞는 정수를 char 변수에 저장하면 해당 정수에 맞는 문제가 저장.
		
		char ch = 'A' + 1;
		int i = 1 ;
		ch = (char)(ch + 1);
		
		
		System.out.println(ch);
		
	}

}
