package day14.homework;

public class ClassEx01 {
	
	/* 하나의 인스턴스를 여러 개의 참조변수가 가르키는 것은 가능하다.
	 * 여러 개의 인스턴스를 하나의 참조변사가 가르키는 것은 불가능하다. */
	
	public static void main(String[] args) {
		
		// 인스턴스(객체 생성)
		// t1과 t2는 각각의 주소를 가지고 있다
		Tv t1 = new Tv(); // t1 : 참조 변수
		Tv t2 = new Tv();
		
		t1.channel = 7;
		
		System.out.println("t1 의 채널 : " + t1.channel); // 7
		System.out.println("t2 의 채널 : " + t2.channel); // 0
		
		// t1의 주소를 t2에 저장한다
		t2 = t1;
		
		System.out.println("t1 의 채널 : " + t1.channel); // 7
		System.out.println("t2 의 채널 : " + t2.channel); // 7
		
	}

}

class Tv {
	
	// 멤버 변수(속성)
	String color;
	boolean power;
	int channel;
	
	// 메소드(기능)
	void power() {
		power = !power;
	}
	
	void channelUp() {
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
}
