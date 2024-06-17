package day14.homework;

public class ClassEx03 {
	
	/* 클래스 변수 : 클래스 영역 (클래스가 메모리에 올라갈때)
	 * 인스턴스 변수 : 클래스 영역 (인스턴스가 생성됐을 때)
	 * 지역 변수 : 클래스 영역 이외의 영역 (변수 선언문이 수행 됐을 때) */
	
	public static void main(String[] args) {
		
		// 클래스 변수는 인스턴스 생성 없이 바로 호출 가능
		System.out.println("카드의 폭 : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		
		// 인스턴스 변수는 인스턴스 생성 후에 호출 가능
		Card c1 = new Card();
		c1.kind = "하트";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind = "스페이드";
		c2.number = 4;
		
		System.out.println("c1의 카드 무늬 : " + c1.kind);
		System.out.println("c1의 카드 숫자 : " + c1.number);
		
		System.out.println("c2의 카드 무늬 : " + c2.kind);
		System.out.println("c2의 카드 숫자 : " + c2.number);
	}

}

class Card {
	
	String kind; // 카드의 무늬
	int number; // 카드의 숫자
	static int width = 100; // 카드의 폭
	static int height = 250; // 카드의 높이
	
	
}
