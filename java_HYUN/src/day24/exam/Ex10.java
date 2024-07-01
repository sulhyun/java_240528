package day24.exam;

import lombok.Getter;
import lombok.Setter;

public class Ex10 {

	public static void main(String[] args) {
		
		PointB p1 = new PointB();
		p1.setX(100);
		
		/* 원인 : print 메소드들 중에서 두 실수를 필요로 하는 메소드가 없음
		 * 해결방법 : 메소드를 오버로딩해서 새 메소드를 추가하던지 실수 대신 정수로 변경*/
		
		p1.print(10.5, 20.5);
	}

}

class PointB {
	@Setter 
	@Getter
	private int x, y;
	
	/* 메소드 오버로딩을 이용하여 print 메소드를 여러개 생성하려고 했다.
	 * 원인 : 잘못된 메소드 오버로딩
	 * 해결방안 : 메소드명을 바꿔주거나 매개변수를 바꿔줘야된다 */
	
	public void print() {
		System.out.println(x + "," + y);
	}
	
	public void print(double x, double y) {
		System.out.println(x + "," + y);
	}
	
	public void print(int x, int y) {
		System.out.println(x + "," + y);
	}
	
	public int printA() {
		System.out.println(x + "," + y);
		return x + y;
	}
}