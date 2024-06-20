package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx01 {

	public static void main(String[] args) {
		/* 다음 메뉴를 가진 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 번호 추가
		 * 2. 번호 삭제
		 * 3. 번호 조희 (Sysout(list))로 대체
		 * 4. 종료 
		 * 매뉴 입력 : */
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int menu;
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 번호 추가");
			System.out.println("2. 번호 삭제");
			System.out.println("3. 번호 조회");
			System.out.println("4. 종료");
			System.out.print("메뉴 입력 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("번호 입력 : ");
				sc.nextLine();
				String number1 = sc.nextLine();
				
				if(list.contains(number1)) {
					System.out.println("이미 등록된 번호입니다.");
					break;
				}
				else {
					list.add(number1);
					System.out.println("등록이 완료되었습니다.");
				}
				break;
			case 2:
				System.out.print("삭제할 번호 입력 : ");
				sc.nextLine();
				String number2 = sc.nextLine();
				
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
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
			}
		}while(menu != 4);
	}

}
