package day24.exam;

public class Ex08 {

	public static void main(String[] args) {
		
		/* 좌표 10, 20 을 이용하여 객체를 생성했는데, 0,0으로 출력이 됐다.
		 * 원인 : 생성자에서 매개 변수값을 필드(멤버 변수)에 저장을 안함
		 * 해결 방법 : 매개변수값을 필드에 저장 */
		
		Point p1 = new Point(10, 20);
		
		p1.print();
		
		/* 기본 생성자를 이용하여 객체를 생성하려고 했는데 에러가 발생
		 * 원인 : 기본 생성자가 없어서, 기본 생성자 대신 Point 메소드가 있음
		 * 해결 방법 : 기본 생성자를 추가 */
		
		Point p2 = new Point();
		
		p2.print();
	}

}

class Point {
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {}
	
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
}