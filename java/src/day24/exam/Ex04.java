package day24.exam;

public class Ex04 {

	public static void main(String[] args) {
		
		int score = 90;
		
		/* A를 판별하는 코드를 작성했는데, A가 아닌 경우에도 A가 출력
		 * 원인 : or 연산자로 인해 90점보다 낮아도 참이 되어 A가 출력
		 * 해결방안 : and 연산자로 바꾸기 */
		
		if(score >= 90 && score <= 100) {
			System.out.println("A");
		}
	}

}
