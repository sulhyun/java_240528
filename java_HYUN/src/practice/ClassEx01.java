package practice;

public class ClassEx01 {

	public static void main(String[] args) {

		Car car = new FireEngine();
		
		System.out.println(car);
		
		FireEngine fe = null;
		
		car = fe;
		
		System.out.println(car);
		
		car = new FireEngine();
		
		car.drive();
		
		fe = (FireEngine)car;
		fe.water();
		
		
	}

}

class Car {
	
	String color;
	String door;
	
	void drive() {
		System.out.println("drive, Brrrr~");
	}
	
	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car {
	
	void water() {
		System.out.println("water!!!");
	}
}
