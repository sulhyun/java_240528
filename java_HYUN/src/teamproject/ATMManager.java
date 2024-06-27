package teamproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ATMManager implements Program {

	Scanner sc = new Scanner(System.in);
	List<ATM> list = new ArrayList<ATM>();
	private int menu;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 계좌등록 | 2. 입금 | 3. 출금 | 4. 계좌이체 | 5. 계좌목록 | 6.거래내역 | 7.종료");
		System.out.print("메뉴 입력 : ");
	}


	@Override
	public void run() {
		
		do {
			printMenu();
			menu = sc.nextInt();
			printBar();
		} while(menu != 7);
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		}
	}
	
	public void printBar() {
		System.out.println("-------------------------------------------------------------------");
	}
	

}
