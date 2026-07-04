package day11;

public class InstanceMemberInitEx01 {

	public static void main(String[] args) {
		
		// 객체 생성하지 않아서 static 초기화 블록까지만 초기화 됨
		System.out.println(B.max);
		
		// 객체를 생성할 때 생성자에서 max 초기화 함
		B b = new B(); 
	
		System.out.println(b.num);
		
		System.out.println(B.max);
	}

}
/** 멤버 변수 초기화 순서
 *  객체 멤버변수 1. 기본값 -> 2. 명시적 초기화 -> 3. 초기화 블록 -> 4. 생성자
 *  클래스 멤버변수 1. 기본값 -> 2. 명시적 초기화 -> 3. 초기화 블록
 * */
class B {
	
	// 명시적 초기화
	public int num = 10;
	public static int max = 20;
	
	// 초기화 블록(인스턴스)
	{
		num = 20;
	}
	
	// 초기화 블록(클래스)
	static {
		max = 20;
	}
	
	// 생성자
	public B() {
		num = 30;
		max = 30;
	
	}
}