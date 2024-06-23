package day14.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex01 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu = 6;
		int count = 0;
		Contact [] list = new Contact[10];
		
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			try {
				menu = sc.nextInt();
				System.out.println("--------------");
				count = runMenu(menu, list, count);
				System.out.println("--------------");
			} catch(InputMismatchException e) {
				System.out.println("번호가 아닙니다.");
				sc.next();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		} while(menu != 5/*입력한 메뉴가 종료가 아닐때*/);
	}
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 등록");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 종료");
		System.out.print("번호 입력 : ");
	}
	
	public static int runMenu(int menu, Contact[] list, int count) throws Exception {
		switch(menu) {
		case 1:
			// 정보를 입력(이름, 번호)
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("번호 : ");
			String number = sc.nextLine();
			// 입력한 정보를 이용하여 객체를 생성
			Contact tmp = new Contact(name, number);
			// 연락처 리스트에 입력한 번호 객체가 있는지 없는지 확인해서
			int index = indexOf(list, count, tmp);
			// 있으면 이미 등록된 번호입니다.라고 출력하고
			if (index >= 0) {
				System.out.println("이미 등록된 번호입니다.");
				break;
			}
			// 없으면 등록이 완료되었습니다.라고 출력
			list[count++] = tmp;
			System.out.println("등록이 완료되었습니다.");
			System.out.println(Arrays.toString(list));
			break;
		case 2:
			// 이름 입력
			sc.nextLine();
			System.out.println("이름 : ");
			name = sc.nextLine();
			// 연락처 리스트에서 이름과 일치하는 연락처를 번지 +1과 함께 출력
			for(int i = 0; i < count; i++) {
				if(list[i].getName().equals(name)) {
					System.out.println();
				}
			}
			// 번호 선택
			
			// 번호가 올바르지 않으면 잘못 선택했습니다.하고 종료
			
			// 올바르면 이름, 번호를 입력받음
			
			// 이름, 번호를 이용하여 객체를 생성
			
			// 생성된 객체를 선택한 번호를 이용하여 수정
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");	
		}
		
		return count;
	}
	
	public static int indexOf(Contact[] list, int count, Contact tmp) {
		if(list == null || count == 0) {
			return -1;
		}
		
		for (int i = 0; i < count; i++) {
			if(list[i].equals(tmp)) {
				return i;
			}
		}
		return -1;
	}
}

class Contact {
	private String name;
	private String number;

	public Contact(String name, String number) throws Exception {
		this.name = name;
		setNumber(number);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(number, other.number);
	}

	@Override
	public String toString() {
		return name + " : " + number;
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
	
	public void setNumber(String number) throws Exception {
		String regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		if(!Pattern.matches(regex, number)) {
			throw new Exception("주어진 번호는 번호 형태가 아닙니다.");
		}
		this.number = number;
	}

	
	
}