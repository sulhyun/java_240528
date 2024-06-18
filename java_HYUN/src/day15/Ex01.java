package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		/* 전화번호를 5번 입력받아 리스트에 저장하는 코드를 작성하세요.
		 * 단, 전화번호는 올바르게 입력했다고 가정.(정규표현식 사용하지 않아도됨)*/
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 5; i++) {
			System.out.print("번호 : ");
			list.add(scan.next());
		}
		
		System.out.println(list);
		
		/* 삭제할 전화 번호를 입력 받아 삭제하는 코드를 작성하세요. */
		
		System.out.print("삭제할 번호 : ");
		list.remove(scan.next());
		
		System.out.println(list);
		
		
		ArrayList<Phone> ph = new ArrayList<Phone>();
		
		
		for(int i = 0; i < 5; i++) {
			System.out.print("이름 입력 :" );
			String name = scan.next();
			System.out.print("번호 입력 : ");
			String number = scan.next();
			ph.add(new Phone(name, number));
			
		}
		System.out.println(ph);
	}

}

class Phone {
	
	private String name;
	private String number;
	
	public Phone(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
