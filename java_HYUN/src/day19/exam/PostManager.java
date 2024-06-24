package day19.exam;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class PostManager implements Program {
	
	private Scanner sc = new Scanner(System.in);
	private List<Post> list = new ArrayList<Post>();
	private int menu;
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	private String fileName = "src/day19/exam/data.txt";
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 입력 : ");
	}


	@Override
	public void run() {
		load(fileName);
		do {
			// 메뉴 출력
			printMenu();
			try {
				// 메뉴 선택
				menu = sc.nextInt();
				// 선택한 메뉴 실행
				runMenu(menu);
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("잘못된 입력입니다.");
			} catch(Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}
		} while(menu != EXIT);
		
		save(fileName);
	}
	
	@Override
	public void load(String fileName) {
		
	}
	
	@Override
	public void save(String fileName) {
		
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}


	private void search() {
		// TODO Auto-generated method stub
		
	}


	private void delete() {
		// TODO Auto-generated method stub
		
	}


	private void update() {
		// TODO Auto-generated method stub
		
	}


	private void insert() {
		// TODO Auto-generated method stub
		
	}
	
}
