package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ScheduleManager implements Program {

	private List<Schedule> list = new ArrayList<Schedule>();
	private Scanner scan = new Scanner(System.in);
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 일정 추가");
		System.out.println("2. 일정 수정");
		System.out.println("3. 일정 삭제");
		System.out.println("4. 일정 확인");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			//update();
			break;
		case DELETE:
			//delete();
			break;
		case SEARCH:
			//search();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");
		}
	}

	private void insert() {
		
	}

	@Override
	public void run() {
		String fileName = "src/day18/homework/schedule.txt";
		
		load(fileName);
		// 프로그램 실행
		int menu = INSERT;
		do {
			// 메뉴 출력
			printMenu();
			try {
				// 메뉴 선택
				menu = scan.nextInt();
				// 선택한 메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("올바른 타입을 입력하세요");
				scan.nextLine(); // 입력 버퍼에 남은 값들을 비워 줌
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != EXIT);
		
		save(fileName);
		
	}

	@Override
	public void save(String fileName) {
		// run() 메소드에 추가한 샘플 데이터들을 이용해서 파일에 저장하는 코드를 작성하세요.
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(list);
		
			} catch (Exception e) {
				System.out.println("저장에 실패했습니다...ㅠㅅㅠ");
			}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		// 파일에 있는 연락처 리스트를 가져와서 list 에 저장하는 코드를 작성
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			list = (List<Schedule>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기에 실패했습니다...ㅠㅅㅠ");
		} 
		
	}

}
