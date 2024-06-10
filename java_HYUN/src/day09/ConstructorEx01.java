package day09;

import java.util.Scanner;

public class ConstructorEx01 {

	/* [생성자]는 객체를 생성할 때만 호출
	 * 그 이외에는 호출할 수가 없다.
	 * [메서드]는 원하는 때 여러번 호출할 수 있다.
	 * */
	
	public static void main(String[] args) {
		
		/* Scanner : 클래스
		 * scan1 : 인스턴스, 객체
		 * Scanner(System.in) : 생성자 - InputStream이 필요한 생성자
		 * */
		Scanner scan1 = new Scanner(System.in);
		
		/* Scanner("...") : 생성자 - String(문자열이)이 필요한 생성자
		 * */
		Scanner scan2 = new Scanner("abc\n123\n1.23");
		
		String str = scan2.next();
		int num = scan2.nextInt();
		double num2 = scan2.nextDouble();
		
		System.out.println(str);
		System.out.println(num);
		System.out.println(num2);
	}

}
