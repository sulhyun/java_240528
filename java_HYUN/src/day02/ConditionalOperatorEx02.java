package day02;

public class ConditionalOperatorEx02 {

	public static void main(String[] args) {
		
		// 조건 연산자
		// num 이 짝수이면 짝수라고 출력하고 
		// 홀수이면 홀수라고 출력하는 코드를 작성하세요.
		
		int num = 3;
		String division = (num % 2 == 0) ? "짝수" : "홀수";
		System.out.println(num + "은 " + division);
	}

}
