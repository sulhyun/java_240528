package day11;

public class InheritanceEx01 {

	public static void main(String[] args) {
		
		// 상속 예제
		HighSchoolStudent std = new HighSchoolStudent();
		std.print();
		std.setAge(10);
		std.print();
		
	}

}


class HighSchoolStudent extends Student {
	
	public void test() {
		
		//System.out.println(schoolName); // 접근제어자가 private 이라서 자식 클래스에서 사용할 수 없다.
		System.out.println(name); // 접근제어자가 protected 이라서 자식 클래스에서 사용할 수 있다.
		System.out.println(age); // 접근제어자가 기본 이라서 자식 클래스에서 사용할 수 있다.
		System.out.println(birthday); // 접근 제어자가 public 이라서 자식 클래스에서 아용할 수 있다.
		
	}
	
}