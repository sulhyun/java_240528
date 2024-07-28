package review;

import java.util.Calendar;
import java.util.Objects;

public class review01 {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		System.out.println(Calendar.DAY_OF_WEEK);
		System.out.println();
		
		Child ch = new Child();
		System.out.println();
		
		SnowTire snowTire = new SnowTire();
		Tire tire = new SnowTire();
		
		snowTire.run(); // 스노우 타이어가 굴러갑니다.
		tire.run();		// 스노우 타이어가 굴러갑니다.
		
	}
		
}
class Parent {
	private String nation;
	
	public Parent() { // 2
		this("대한민국");
		System.out.println("Parent() Call");
	}
	
	public Parent(String nation) { // 1
		this.nation = nation;
		System.out.println("Parent(String nation) Call");
	}
}
class Child extends Parent {
	private String name;
	
	public Child() { // 4
		this("홍길동");
		System.out.println("Child() Call");
	}
	
	public Child(String name) { // 3
		this.name = name;
		System.out.println("Child(String name) Call");
	}
}

class Tire {
	
	public void run() {
		System.out.println("일반 타이어가 굴러갑니다.");
	}
}

class SnowTire extends Tire {
	
	@Override
	public void run() {
		System.out.println("스오누 타이어가 굴러갑니다.");
	}
}