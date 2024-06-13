package day12;

public class AbstractClassEx01 {

	public static void main(String[] args) {
		
		/* 추상 클래스를 이용하여 객체를 생성할 수 없다.*/
		// Animal anlmal = new Animal(); (에러)
		
		Cat cat = new Cat();
		cat.bark();
		
		Dog dog = new Dog();
		dog.bark();
		
		Tiger tiger = new Tiger();
		tiger.bark();
		
		Animal[] animals = new Animal[3];
		/* 포함 다형성으로 추상 클래스를 활용할 수 있다.*/
		animals[0] = cat; // 업캐스팅
		animals[1] = dog;
		animals[2] = tiger;
		
		for (Animal tmp : animals) {
			tmp.bark();
		}
	}

}

/* 추상클래스는 객체를 만들수 없다. */
abstract class Animal {
	
	public String name;
	public String species; // 과
	
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	
	public void eat(String food) {
		System.out.println(food + "를 먹습니다.");
	}
	
	/* bark() 메소드는 Animal 클래스를 상속 받는 모든 클래스들이 bark 를 오버라이딩 해야하기 때문에
	 * 굳이 구현자히 않아도 됨. 그래서 추상 메소드로 만듬 => Animal 클래스는 추상 메소드가 있기 때문에
	 * 추상 클래스로 바꾸어야 함 */
	public abstract void bark();

	
}

/* 부모 클래스가 추상 클래스라면
 * 자식 클래스는 추상 메소드를 오버라이딩을 허가나, 같은 추상 클래스가 되어야한다.*/
class Cat extends Animal {
	
	public Cat() {
		name = "고양이";
		species = "고양이과";
	}
	
	@Override
	public void bark() {
		System.out.println("야옹");
	}
}

class Dog extends Animal {
	
	public Dog() {
		name = "개";
		species = "개과";
	}

	@Override
	public void bark() {
		System.out.println("멍멍");
	}
	
}

class Tiger extends Animal {
	
	public Tiger() {
		name = "호랑이";
		species = "고양이과";
	}
	
	@Override
	public void bark() {
		System.out.println("어흥");
	}
}

/* 추상 클래스는 추상 메소드가 반드시 들어가는 것이 아니다. */
abstract class Test1 {
	
}