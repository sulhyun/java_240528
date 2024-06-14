package day13.homework;

import java.util.Scanner;

public class PhoneEx01 {

	private static Scanner scan = new Scanner(System.in);
	
	/* 연락처 관리를 위한 프로그램을 만드세요.
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ----------
	 * 이름 : 홍길동
	 * 번호 : 010-1231-2333
	 * ----------
	 * 등록이 완료되었습니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ----------
	 * 이름 : 홍길동
	 * 번호 : 010-1234-2333
	 * ----------
	 * 등록이 완료되었습니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ----------
	 * 이름 : 고길동
	 * 번호 : 010-1231-2333
	 * ----------
	 * 이미 등록된 번호입니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 2
	 * ----------
	 * 이름 : 홍
	 * 1. 홍길동 : 010-1231-2333
	 * 2. 홍길동 : 010-1234-2333
	 * 번호 선택 : 1
	 * 이름 : 홍길동
	 * 번호 : 010-7894-5678
	 * ----------
	 * 수정이 완료되없습니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 2
	 * ----------
	 * 이름 : 홍
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-1234-2333
	 * 번호 선택 : 1
	 * 이름 : 홍길동
	 * 번호 : 010-1234-2333
	 * ----------
	 * 이미 등록된 번호입니다.
	 * ----------
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 4
	 * ----------
	 * 검색할 이름을 작성하세요(전체 검색 : 엔터) :
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-1234-2333
	 * ----------
	 * * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 3
	 * ----------
	 * 이름 : 홍
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-1234-2333
	 * 삭제할 번호 선택 : 1
	 * ----------
	 * 번호를 삭제했습니다.
	 * */
	
	public static void main(String[] args) {
		
		int menu;
		Phone[] ph = new Phone[3];
		String name, phoneNum;
		int phoneCnt = 0;
		boolean isTrue;
		int count = 0;
		int num;
		
		do {
			printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:// 연락처 추가
				if (phoneCnt == ph.length) {
					System.out.println("더이상 등록될 수 없습니다.");
					break;
				}
				System.out.print("이름 : ");
				name = scan.next();
				System.out.print("번호 : ");
				phoneNum = scan.next();
				isTrue = false;
				for(int i = 0; i < phoneCnt; i++) {
					if (phoneNum.equals(ph[i].getPhoneNum())) {
						System.out.println("이미 등록된 번호입니다.");
						isTrue = true;
						break;
					}
				}
				if(!isTrue) {
					ph[phoneCnt] = new Phone(name, phoneNum);
					System.out.println("등록이 완료되었습니다.");
					phoneCnt++;
				}
				break;
			case 2: // 연락처 수정
				System.out.print("이름 : ");
				name = scan.next();
				for(int i = 0; i < phoneCnt; i++) {
					if(ph[i].getName().contains(name)) {
						System.out.println(count + 1 + ". " + ph[i].getName() + " : " 
								+ ph[i].getPhoneNum());
						count++;
					}
				}
				if(count == 0) {
					System.out.println("이미 등록된 번호입니다.");
				}
				// 번호 선택을 받고
				System.out.print("번호 선택 : ");
				num = scan.nextInt();
				// 있는 번호라면 이미 등록된 번호라고 출력
				
				// 없으면 해당 번호 수정
				
				break;
			case 3: // 연락처 삭제
				break;
			case 4: // 연락처 검색
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 명령입니다.");
			}
		} while(menu != 5);
		
		
		
	}
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}

class Phone {
	private String name;
	private String phoneNum;
	
	public Phone() {}
	
	public Phone(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
