package day10;

public class MethodEx01 {

	public static void main(String[] args) {
		
		/* 중요 */
		/*안바뀜*/
		int num1 = 10, num2 = 20;
		System.out.println("swap1 전 num = " + num1 + ", num2 = " + num2);
		swap1(num1, num2);
		System.out.println("swap1 후 num = " + num1 + ", num2 = " + num2);
		System.out.println("========================");
		/*안바뀜*/
		A a1 = new A(10), a2 = new A(20);
		System.out.println("swap2 전 a1 = " + a1.num + ", a2 = " + a2.num);
		swap2(a1, a2);
		System.out.println("swap2 후 a1 = " + a1.num + ", a2 = " + a2.num);
		System.out.println("========================");
		/*바뀜*/
		System.out.println("swap3 전 a1 = " + a1.num + ", a2 = " + a2.num);
		swap3(a1, a2);
		System.out.println("swap3 후 a1 = " + a1.num + ", a2 = " + a2.num);
	}
	
	/*안바뀜*/
	public static void swap1(int num1, int num2) {
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}
	/*안바뀜*/
	public static void swap2(A a1, A a2) {
		A tmp = a1;
		a1 = a2;
		a2 = tmp;
	}
	/*바뀜(중요)*/
	public static void swap3(A a1, A a2) {
		int tmp = a1.num;
		a1.num = a2.num;
		a2.num = tmp;
	}
}

class A {
	public int num;
	
	public A(int num) {
		this.num = num;
	}
}
