package day16;

public class LamdaEx01 {

	/* 함수형 인터페이스 종류
	 * Consumer : 매개변수 O, 리턴 X, 주로 출력
	 * Supplier : 매개변수 X, 리턴 O
	 * Function : 매개변수 O, 리턴 O
	 *  - 매개변수와 리턴타입의 타입이 다름
	 * Operator : 매개변수 O, 리턴 O
	 * 	- 매개변수와 리턴타입이 타입이 같음
	 * Predicate : 매개변수 O 리턴 boolean */
	
	public static void main(String[] args) {
		
		// 람다식을 사용하지 않았을때
		A a1 = new A() {
			@Override
			public int sum(int num1, int num2) {
				return num1 + num2;
			}
		};
	
		// 2. 익명 클래스 객체 생성
		A a2 = (n1, n2) -> {
			return n1 + n2;
		};
		
		/* 구현부가 한줄인 경우 {}를 생략할 수 있고 {}를 생략할때 return 이 있으면
		 * return 을 생략해야 한다. */
		A a3 = (n1, n2) -> n1 + n2;
		
		// 매개변수가 1개이면 ()를 생략할 수 있다.
		B b1 = n1 -> System.out.println(n1);
		
		// 3. 생성한 객체를 이용하여 기능 호출
		System.out.println(a1.sum(10,20));
		System.out.println(a2.sum(10,20));
		System.out.println(a3.sum(10,20));
		
		b1.print(10);
	}

}

/* 람다식 사용하기
 * 1. 추상메서드가 1개인 인터페이스를 생성
 * 2. main 메서드가 있는 클래스에서 1에서 생성한 인터페이스를 구현한
 * 	익명 클래스 객체 생성
 * 3. 2에서 생성한 객체를 이용하여 기능 호출 */

interface A{
	
	// 1. 추상메서드가 1개인 인터페이스 생성
	int sum(int num1, int num2);
}

interface B {
	void print(int num1);
}

// @FunctionalInterface : 추상 메서드가 1개가 아니면 에러 발생

@FunctionalInterface
interface C {
	void test();
}