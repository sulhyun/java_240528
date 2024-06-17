package day14.homework;

public class ClassEx04 {
	
	/* 메서드
	 * 1. 한가지 기능만 수행하도록 하는것이 좋음
	 * 2. 반복적으로 수행되어야 하는 여러 문장을 하나의 메서드로 정의하는 것이 좋음
	 * 3. 관련된 여러 문장을 하나의 메서드로 만드는것이 좋음*/
	
	public static void main(String[] args) {
		
		myMath mm = new myMath();
		
		System.out.println(mm.add(2, 4));
		System.out.println(mm.subtract(2, 4));
		
	}
}

class myMath {
	
	long add(long a, long b) {
		return a + b;
	}
	
	long subtract(long a, long b) {
		return a- b;
	}
}