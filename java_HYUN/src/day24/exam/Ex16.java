package day24.exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex16 {

	public static void main(String[] args) {
		/* 1. 이름과 나이를 저장하고 관리하는 클래스를 생성하세요
		 * 2. 이름이 홍길동, 나이는 21인 객체를 생성하세요.
		 * 3. src/day24/ex16.txt에 2번에서 작성한 객체를 저장하세요.*/
		
		Person p1 = new Person("홍길동", 21);
		
		try( ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("src/day24/exam/ex16.txt"))) {
				oos.writeObject(p1);
				oos.flush();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		/* 4. src/day24/exam/ex16.txt에 저장된 객체를 불러온 후 콘솔창에 출력하는 코드를 작성하세요.*/
		
		try( ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("src/day24/exam/ex16.txt"))) {
			/* (Person)을 생략하면 에러 발생
			 * 원인 : readObject는 리턴이 Object인데, 다운캐스팅은 자동으로 이루어지지 않는다.
			 * 		 그래서 명시적으로 클래스형변환을 해야한다.
			 * */
				Person p2 = (Person)ois.readObject();
				System.out.println(p2.getName());
				System.out.println(p2.getAge());
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}

@Data
@AllArgsConstructor
class Person implements Serializable{
	
	private static final long serialVersionUID = -1059570330848511049L;
	
	private String name;
	private int age;
}