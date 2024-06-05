package day07.homework;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] list = new String[10];
		String word, tmp; // word : 추가 tmp : 검색
		boolean isTrue = false;
		int menu;
		int cnt = 0;
		do {
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			switch (menu) {
			case 1: // 추가
				System.out.println("------------");
				while(true) {
	
					System.out.print("단어입력(종료:-1): ");
					word = sc.next();
					
					if (word.equals("-1")) {
						System.out.println("종료합니다.");
						break;
					}
					
					if (cnt < list.length) {
						list[cnt] = word;
						cnt++;
						System.out.println("단어를 추가했습니다.");
					}
					else {
						System.out.println("단어를 추가하지 못했습니다.");
					}
				}
				System.out.println("------------");
				break;
			case 2: // 검색
				System.out.println("------------");
				while(true) {
					System.out.print("단어입력(종료:-1) : ");
					tmp = sc.next();
					
					if (tmp.equals("-1")) {
						System.out.println("종료합니다.");
						break;
					}
					
					isTrue = false;
					for (int i = 0; i < cnt; i++) {
						String spare = list[i];
						if (tmp.equals(spare)) {
							isTrue = true;
							break;
						}
						
					}
					if (isTrue) {
						System.out.println("있습니다 (O)")
						;
					} else {
						System.out.println("없습니다 (X)");
					}
					
					
				}
				System.out.println("------------");
				break;
			case 3: // 종료
				System.out.println("------------");
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("------------");
				System.out.println("잘못된 메뉴입니다.");
				System.out.println("------------");
			}
		} while(menu != 3);
	}

}
