package day07;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		
		/*
		Exam01 ~ 03 기능을 하나로 합쳐서 기능을 구현하세요
		메뉴
		1. 추가
		2. 검색
		3. 종료
		메뉴 선택 : 1
		-----------
		단어입력 (종료: -1) : cat
		단어를 추가했습니다.
		단어입력 (종료: -1) : dog
		단어를 추가햇습니다.
		단어입력 (종료: -1) : good
		단어를 추가하지 못했습니다.
		단어입력 (종료: -1) : -1
		종료합니다.
		-----------
		메뉴
		1. 추가
		2. 검색
		3. 종료
		메뉴 선택 : 0
		-----------
		단어 입력 (종료:-1) : apple
		없는 단어입니다.
		단어 입력 (종료:-1) : cat
		있는 단어입니다.
		단어 입력 (종료:-1) : -1
		종료합니다.
		-----------		
		메뉴
		1. 추가
		2. 검색
		3. 종료
		메뉴 선택 : 0
		-----------
		잘못된 메뉴입니다
		-----------
		메뉴
		1. 추가
		2. 검색
		3. 종료
		메뉴 선택 : 3
		------------
		프로그램을 종료합니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		String[] list = new String[10];
		int menu;
		int count = 0; // 추가한 문자 갯수
		String tmp; // 추가할 문자 입력을 저장할 변수
		String word; //
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("-----------");
				while (true) {
					System.out.print("단어 입력 (종료:-1) : ");
					word = sc.next();
					
					if (word.equals("-1")) {
						System.out.println("종료합니다.");
						break;
					}
					if(list.length == count) {
						System.out.println("단어를 추가하지 못했습니다.");
						
					}
					else {
						list[count] = word;
						count++;
						System.out.println("단어를 추가했습니다.");
					}

				}
				System.out.println("-----------");
				break;
			case 2:
				System.out.println("-----------");
				while(true) {
					System.out.print("단어 입력 (종료:-1) : ");
					tmp = sc.next();
					
					if (tmp.equals("-1")) {
						System.out.println("종료합니다.");
						break;
					}
					
					boolean isTrue = false;
					for (int i = 0; i < count; i++) {
						String tmp1 = list[i];
						if (tmp.equals(tmp1)) {
							isTrue = true;
						}
					}
					
					if(isTrue) {
						System.out.println("있는 단어입니다.(O)");
					}
					else {
						System.out.println("없는 단어입니다.(X)");
					}
					
				}
				System.out.println("-----------");
				break;
			case 3:
				System.out.println("-----------");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("-----------");
				break;
			default:
				System.out.println("-----------");
				System.out.println("잘못된 명령입니다.");
				System.out.println("-----------");
			}
		} while (menu!=3);
		
	}

}
