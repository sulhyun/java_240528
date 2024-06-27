package Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentManager implements Program {

	// 학생 성적 관리를 위한 리스트
	private List<Student> list = new ArrayList<Student>();
	// 과목 관리를 위한 리스트
	private Scanner scan = new Scanner(System.in);
	private List<Subject> subjectList = new ArrayList<Subject>();
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 관리");
		System.out.println("2. 과목 관리");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void run() {
		
		int menu;
		
		do {
			// 메뉴 출력
			printMenu();
			
			// 메뉴 입력
			menu = nextInt();
			
			try {
				// 메뉴 실행
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외 발생");
			}
			
		}while(menu != 3);
	}
	
	/**
	 * 콘솔에서 정수를 입력받아 반환하는 메소드로 잘못입력하면 (문자열) 
	 * 정수의 가장 작을 수를 반환
	 * @return 입력한 정수 또는 정수의 가장 작은 수 */
	
	public int nextInt() {
		
		try {
			return scan.nextInt();
		} catch(InputMismatchException e) {
			scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에 비워줌
			return Integer.MIN_VALUE; // int의 가장 수를 리턴
		}
	}

	@Override
	public void runMenu(int menu) throws Exception {
		
		switch(menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			exit();
			break;
		default:
		}
	}

	private void student() {
		int menu;
		
		do {
			printStudentMenu();
			menu = nextInt();
			runStudentMenu(menu);
		} while(menu != 5);
	}

	private void printStudentMenu() {
		
		System.out.println("학생 관리 메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 조회");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");
	}

	private void runStudentMenu(int menu) {
		
		switch(menu) {
		case 1:
			studentInsert();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentDelete();
			break;
		case 4:
			studentSearch();
			break;
		case 5:
			prev();
			break;
		default:
		}
	}

	private void studentInsert() {
		// 학생을 추가하는 기능을 구현하세요.
		// 학년, 반, 번호, 이름을 입력
		// 입력한 정보를 이용하여 객체를 생성
		Student student = inputStudentExpand();
		
		// 객체가 리스트에 있으면 안내문구 출력 후 종료
		if(list.contains(student)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}	
		
		// 없으면 추가 후 안내무구 출력
		list.add(student);
		System.out.println("학생이 등록되었습니다.");
	}
	
	/**
	 * 학년 반 번호를 입력받아 학생 객ㅊ를 만들어서 반화하는 메소드
	 * @return 만들어진 학생 객체 */
	
	public Student inputStudent() {
		// 학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();

		return new Student(grade, classNum, num, "");
	}
	
	/**
	 * 한년 반 번호 이름을 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * @return 학년, 반, 번호, 이름이 있는 만들어진 학생 객체 */
	
	public Student inputStudentExpand() {
		
		Student student = inputStudent();
		scan.nextLine();
		System.out.print("학생 이름 :");
		String name = scan.nextLine();
		student.setName(name);
		
		return student;
	}

	private void studentUpdate() {
		
		int menu;
		do {
			printStudentUpdateMenu();
			menu = nextInt();
			runStudentUpdateMenu(menu);
		} while(menu != 5);
	}

	private void printStudentUpdateMenu() {
		System.out.println("학생 수정 메뉴");
		System.out.println("1. 학생 정보 수정");
		System.out.println("2. 성적 추가");
		System.out.println("3. 성적 수정");
		System.out.println("4. 성적 삭제");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");
	}

	private void runStudentUpdateMenu(int menu) {
		
		switch(menu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void studentDelete() {
		// 학년, 반, 번호를 입력
		// 입력한 정보를 이용하여 객체를 생성
		Student student = inputStudent();
		
		// 리스트에서 학생 객체를 삭제하고 삭제에 성공하면 알림문구 출력 후 종료
		if(list.remove(student)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		// 아니면 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");
	}

	private void studentSearch() {
		// 학년, 반, 번호를 입력후 객체를 생성
		Student student = inputStudent();
		// 생성된 객체와 일치하는 객체를 가져옴
		// 리스트에서 객체와 일치하는 번지를 가져옴
		int index = list.indexOf(student);
		// 번지가 0보다 작으면 객체에 null을 저장
		if (index < 0) {
			student = null;
		}
		// 아니면 객체에 번지에 있는 객체를 가져옴
		else {
			student = list.get(index);
		}
		// 가져온 객체가 null이면 안내문구 출력 후 종료
		if(student == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		// null이 아니면 학생 정보를 출력
		student.print();
		
	}

	private void prev() {
		// TODO Auto-generated method stub
		
	}

	private void subject() {
		
		int menu;
		do {
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu(menu);
		}while(menu != 5);
	}

	private void printSubjectMenu() {
		
		System.out.println("과목 관리 메뉴");
		System.out.println("1. 과목 추가");
		System.out.println("2. 과목 수정");
		System.out.println("3. 과목 삭제");
		System.out.println("4. 과목 확인");
		System.out.println("5. 이전으로");
		System.out.print("메뉴 선택 : ");
	}

	private void runSubjectMenu(int menu) {
		// TODO Auto-generated method stub
		
	}

	private void exit() {
		// TODO Auto-generated method stub
		
	}


}
