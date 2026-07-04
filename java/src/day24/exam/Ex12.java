package day24.exam;

public class Ex12 {

	public static void main(String[] args) {
		
		/* 1 + 2의 결과를 출력하기 위해 다음과 같이 작성했다.
		 * 원인 : 리턴 타입이 void 이므로 값을 메소드 밖으로 빼낼수 가 없기 때문에 
		 * 해결방법 : 메소드를 바로 호출허가나, 리턴 타입을 int 로 바꿔줘야 됌*/
		
		sum(1, 2);
	}
	
	public static void sum(int num1, int num2) {
		System.out.println(num1 + num2);
	}

}
