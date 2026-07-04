package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/* 다음 메뉴를 가진 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 번호 추가
		 * 2. 번호 삭제
		 * 3. 번호 조희 (Sysout(list))로 대체
		 * 4. 종료 */
		
		ArrayList<String> list = new ArrayList<String>();
		int menu;
		String name, number;
		do {
			System.out.println("메뉴");
			System.out.println("1. 번호 추가");
			System.out.println("2. 번호 삭제");
			System.out.println("3. 번호 조희");
			System.out.println("4. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.print("추가할 번호 입력 : ");
				String number1 = sc.next();
				if(list.contains(number1)) {
					System.out.println("이미 등록된 번호입니다.");
				}
				else {
					System.out.println("번호를 등록했습니다.");
					list.add(number1);
				}
				break;
			case 2:
				System.out.print("삭제할 번호 입력 : ");
				String number2 = sc.next();
				if(list.remove(number2)) {
					System.out.println("삭제가 완료되었습니다.");
				}
				else {
					System.out.println("없는 번호입니다.");
				}
				break;
			case 3:
				System.out.println(list);
				break;
			case 4:
				System.out.println("프로그램 종료");
				break;
			default:
			}
		} while(menu != 4);
		
	}

}
