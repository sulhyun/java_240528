package teamproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import program.Program;

public class ATMManager implements Program {

	Scanner sc = new Scanner(System.in);
	List<ATM> list = new ArrayList<ATM>();
	Set<String> set = new HashSet<String>(); // 계좌번호 생성할 공간
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 계좌등록");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌이체");
		System.out.println("5. 계좌목록");
		System.out.println("6. 거래내역");
		System.out.println("7. 종료");
		System.out.print("메뉴 입력 : ");
	}


	@Override
	public void run() {
		
		int menu = 0;
		
		do {
			printMenu();
			menu = sc.nextInt();
			printBar();
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while(menu != 7);
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		case 1:
			registration(); // 계좌 등록
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		default:
		}
	}
	
	private void registration() throws Exception {
		// 이름과 비밀번호를 입력받고
		System.out.print("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		printBar();
		System.out.print("비밀번호(4자리) : ");
		String pw = sc.next();
		printBar();
		
		// 객체에 이름과 비밀번호를 저장하고
		ATM atm = new ATM(name, pw);
		
		// 이름과 비밀번호가 똑같은 사람이 있는지 확인
		// 있으면 안내문구 출력후 종료
		if(list.contains(atm)) {
			System.out.println("동일한 이름과 비밀번호가 있습니다.");
			printBar();
			return;
		}
		
		// 없으면 계좌번호 생성
		String accountNum = createAccountNum();
		atm.setAccountNum(accountNum);
		System.out.println("계좌번호 : " + accountNum);
		
		// 리스트에 저장
		list.add(atm);
		System.out.println(atm.getName() + "님 계좌가 등록되었습니다.");
		printBar();
	}

	private String createAccountNum() {
		
		int min = 100000, max = 999999;
		String accountNum;
		do {
			int random = (int)(Math.random() * (max - min + 1) + min);
			accountNum = String.valueOf(random);
		}while(!set.add(accountNum));
		
		return String.format("%s-%s", accountNum.substring(0, 3), accountNum.substring(3));
	}


	public void printBar() {
		
		System.out.println("--------------------");
	}

	public int nextInt() {

		try {
			return sc.nextInt();
		} catch(InputMismatchException e) {
			sc.nextLine();
			return Integer.MIN_VALUE;
		}
	}

}
