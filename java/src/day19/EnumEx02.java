package day19;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EnumEx02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("계절을 입력하세요(봄:1, 여름:2, 가을:3, 겨울:4) : ");
		Season2 s = null;
		try {
			int num = scan.nextInt();
			s = Season2.fromeValue(num);
			switch(s) {
			case SPRING:
				System.out.println("봄입니다.");
				break;
			case SUMMER:
				System.out.println("여름입니다.");
				break;
			case FALL:
				System.out.println("가을입니다.");
				break;
			case WINTER:
				System.out.println("겨울입니다.");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}

enum Season2 {
	
	SPRING(1),
	SUMMER(2),
	FALL(3),
	WINTER(4);
	
	private final int value; // 1,2,3,4로 했기 때문에 정수인 int
	
	private Season2(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	// 정수를 이용하여 열거형 객체를 선택하는 클래스(정적) 메소드
	public static Season2 fromeValue(int value) {
		for(Season2 tmp : Season2.values()) {
			if(tmp.getValue() == value) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("잘못된 계절입니다.");
	}
}