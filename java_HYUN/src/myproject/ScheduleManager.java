package myproject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ScheduleManager implements Program {
	
	private Scanner sc = new Scanner(System.in);
	private String fileName = "src/myproject/schedule.txt";
	private List<ScheduleMember> list = new ArrayList<ScheduleMember>();
	
	
	@Override
	public void load(String fileName) {
		System.out.println("파일 불러오기");
	}
	
	@Override
	public void save(String fileName) {
		System.out.println("파일 저장하기");
	}
	
	public void printBar() {
		System.out.println("--------------");
	}

	@Override
	public void printMenu() {
		System.out.print(
				"메인 메뉴\n"
				+ "1. 회원 관리\n"
				+ "2. 일정 관리\n"
				+ "3. 프로그램 종료\n"
				+ "--------------\n"
				+ "메뉴 선택 : ");
		
	}
	@Override
	public void run() {
		load(fileName);
		int menu = 0; 
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				printBar();
				runMenu(menu);
			} catch(InputMismatchException e) {
				sc.nextLine();
				printBar();
				System.out.println("잘못된 입력입니다.");
				printBar();
			} catch (Exception e) {
				System.out.println("예외 발생");
			}
		} while(menu != 3);
		save(fileName);
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			Member();
			break;
		case 2:
			Schedule();
			break;
		case 3:
			exit();
			break;
		default:
			printDefault();
		}
	}

	private void Member() {
		int menu = 0;
		do {
			printMember();
			try {
				menu = sc.nextInt();
				printBar();
				runMember(menu);
			} catch(InputMismatchException e) {
				sc.nextLine();
				printBar();
				System.out.println("잘못된 입력입니다.");
				printBar();
			}
		} while(menu != 4);
	}

	private void runMember(int menu) {
		switch(menu) {
		case 1:
			insertMember();
			break;
		case 2:
			updateMember();
			break;
		case 3:
			deleteMember();
			break;
		case 4:
			previously();
			break;
		default:
			printDefault();
		}
	}

	private void insertMember() {
		// 아이디와 이름을 입력하고 객체에 저장
		System.out.println("추가할 회원 정보 입력");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		ScheduleMember sm = new ScheduleMember(id, name);
		printBar();
		// 객체의 아이디가 리스트에 동일한게 있다면
		if(list.contains(sm)) {
			// 안내문구 출력후 종료
			System.out.println("이미 등록된 아이디가 있습니다.");
			printBar();
			return;
		}
		// 없다면 추가
		list.add(sm);
		System.out.println(list);
		System.out.println("회원이 추가됐습니다.");
		printBar();
	}

	private void updateMember() {
		
	}

	private void deleteMember() {
		// TODO Auto-generated method stub
		
	}

	private void previously() {
		System.out.println("메인 메뉴로 돌아갑니다.");
		printBar();
	}

	private void printMember() {
		System.out.print(
				"회원 메뉴\n"
				+ "1. 회원 추가\n"
				+ "2. 회원 수정\n"
				+ "3. 회원 삭제\n"
				+ "4. 이전으로\n"
				+ "--------------\n"
				+ "메뉴 선택 : ");
	}

	private void Schedule() {
		// TODO Auto-generated method stub
		
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
		printBar();
	}

	private void printDefault() {
		System.out.println("잘못된 메뉴입니다.");
		printBar();
	}


}
