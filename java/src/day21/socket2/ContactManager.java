package day21.socket2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ContactManager implements Program {

	private Scanner scan = new Scanner(System.in);
	private List<Contact> list = new ArrayList<Contact>();
	private int menu;
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void load(String fileName) {
		
	}
	
	@Override
	public void save(String fileName) {
		
	}

	@Override
	public void run() {
		
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch (InputMismatchException e) {
				System.out.println("숫자만 입력하세요.");
			}catch (Exception e) {
				System.out.println("예외 발생");
			}
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			break;
		case DELETE:
			break;
		case SEARCH:
			break;
		case EXIT:
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void insert() throws Exception {
		scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("번호 : ");
		String number = scan.nextLine();
		Contact contact = new Contact(name, number);
		boolean isTrue = checkNum(list, contact);
	}

	private boolean checkNum(List<Contact> list2, Contact contact) {
		if(list.size() == 0) {
			return false;
		}
		return true;
	}
}
