package day13.homework;

import java.util.Scanner;

public class PhoneEx01 {
	
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
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int menu; // 메뉴 입력
		Phone[] phone = new Phone[5]; // 이름 번호 저장
		String name, phoneNum; // 이름과 번호 입력
		int phoneCount = 0; // 현재 저장된 번호 갯수
		boolean isFalse; // 동일한 번호가 있는지 확인
		int num = 0;
		int count = 0;
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 연락처 추가");
			System.out.println("2. 연락처 수정");
			System.out.println("3. 연락처 삭제");
			System.out.println("4. 연락처 검색");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			// 메뉴를 입력 받으면 그 값에 맞는 case 문으로 이동
			// 정수말고 다른 리터럴을 넣으면 예외 발생 : InputMismatchException
			switch(menu) { 
			case 1: // 연락처 추가
				// 배열에 꽉 차면 저장공간이 없습니다. 출력후 종료
				if (phone.length == phoneCount) {
					System.out.println("저장 공간이 없습니다.");
					break;
				}
				// 이름과 번호를 입력
				System.out.print("이름 : ");
				name = scan.next();
				System.out.print("번호 : ");
				phoneNum = scan.next();
				// 등일한 번호가 있는지 확인
				isFalse = phoneTF(phone, phoneCount, phoneNum);
				// 없다면 객체 배열에 넣어주기
				if(!isFalse) {
					phone[phoneCount] = new Phone(name, phoneNum);
					phoneCount++;
					System.out.println("등록이 완료되었습니다.");
				}
				// 이름 순으로 정렬
				phoneSort(phone, phoneCount);
				// 저장된 값 확인 용도
				for (Phone tmp : phone) {
					if(tmp != null) {
						tmp.print();
					}
				}
				break;
			case 2: // 연락처 수정
				// 이름을 입력
				System.out.print("이름 입력 : ");
				name = scan.next();
				// 동일한 이름 확인
				phoneDuplication(phone, phoneCount, name);
				// 번호 입력
				System.out.print("번호 입력 : ");
				num = scan.nextInt();
				// 번호가 해당 숫자를 넘어간다면 잘못 입려됐다고 출력후 종료
				if (phone.length <= num || num < 0) {
					System.out.println("잘못된 번호입니다.");
					break;
				}
				if(phone[num] == null) {
					System.out.println("잘못된 번호입니다.");
					break;
				}
				// 이름과 번호를 입력
				System.out.print("이름 입력 : ");
				name = scan.next();
				System.out.print("번호 입력 : ");
				phoneNum = scan.next();
				// 동일한 번호가 있는지 확인
				isFalse = phoneTF(phone, phoneCount, phoneNum);
				// 없다면 해당 번호 정보 수정
				if (!isFalse) {
					phone[num - 1].updateData(name, phoneNum);
				}
				// 이름 순으로 정렬
				phoneSort(phone, phoneCount);
				// 저장된 값 확인 용도
				for (Phone tmp : phone) {
					if(tmp != null) {
						tmp.print();
					}
				}
				break;
			case 3: // 연락처 삭제
				System.out.println("삭제 기능 구현 중입니다.");
				break;
			case 4: // 연락처 검색
				System.out.println("검색 기능 구현 중입니다.");
				break;
			case 5: // 프로그램 종료
				System.out.println("프로그램 종료입니다.");
				break;
			default: // 잘못된 메뉴를 넣으면 잘못된 명령이라고 출력
				System.out.println("잘못된 명령입니다.");
			}
		} while(menu != 5); // 메뉴가 5가 아니면 계속 반복
	}
	
	/**기능 : 동일한 번호가 있는 판별하는 메소드 있으면 true 없으면 false
	 * @param String phoneNum
	 * @param int phoneCount
	 * @param Phone[] phone
	 * @return true, false */
	public static boolean phoneTF(Phone[] phone, int phoneCount, String phoneNum) {
		// 등일한 번호가 있는지 확인
		for(int i = 0; i < phoneCount; i++) {
			// 있다면 츌력문을 출력하고 종료
			if(phone[i].getPhoneNum().equals(phoneNum)) {
				System.out.println("이미 등록된 번호입니다.");
				return true;
			}
		}
		return false;
	}
	
	/** 기능 : 이름을 따라 사전 순으로 정렬하는 메소드
	 * @param Phone[] phone
	 * @param int phoneCount*/
	public static void phoneSort(Phone[] phone, int phoneCount) {
		for(int i = 0; i < phoneCount - 1; i++) {
			for(int j = 0; j < phoneCount - 1 - i; j++) {
				if(phone[j].getName().compareTo(phone[j+1].getName()) > 0) {
					Phone tmp = phone[j];
					phone[j] = phone[j+1];
					phone[j+1] = tmp;
				}
			}
		}
	}
	
	public static void phoneDuplication(Phone[] phone, int phoneCount, String name) {
		int count = 0;
		for (int i = 0; i < phoneCount; i++) {
			// 같은 이름이 있는지 확인
			if(phone[i].getName().contains(name)) {
				// 있다면 번호 부여해서 출력
				System.out.println(i + 1 + ". " + phone[i].getName() + " : "
						+ phone[i].getPhoneNum());
				count++;
			}
		}
		// 없다면 출력후 종료
		if (count == 0) {
			System.out.println("등록된 이름이 없습니다.");
		}
	}

}

class Phone {
	
	private String name, phoneNum;
	
	public Phone() {}

	public Phone(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public void updateData(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public void print() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + phoneNum);
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