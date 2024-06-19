package practice;

public class ClassEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Point {
	
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0,0);
	}
}

class Circle {
	
	Point center;
	int r;
	
	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	public Circle() {
		this(new Point(0,0), 100);
	}
}

class Triangle {
	
	Point[] p = new Point[3];
	
	public Triangle(Point[] p) {
		this.p = p;
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
	}
}