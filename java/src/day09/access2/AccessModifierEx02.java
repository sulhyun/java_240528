package day09.access2;

import day09.access.Student;

public class AccessModifierEx02 {
	
	/* 접근 제어자 예제 */
	public static void main(String[] args) {

		Student std1 = new Student();
		// 접근제어자 : public
		std1.grade = 1; //다른 클래스에서 사용가능
		
		// 접근제어자 : protected
		// std1.classNum = 1; // 다른 패키지에 있는 다른 클래스에서 사용 불가능
		
		// 접근제어자 : default
		// std1.num = 1; // 다른 패키지에 있는 다른 클래스에서 사용 불가능
		
		// 접근제어자 : private
		// std1.name = "홍길동"; // 다른 클래스에서 사용이 불가능
	}

}
