package day09;

import java.util.Scanner;

public class StudentEx01 {
	
	/* 학생 성적을 관리하기 위한 프로그램 예제 : 국어, 영어 수학 */
	
	public static void main(String[] args) {
		
		/* 다음 메뉴가 출력되도록 코드를 작성하세요.
		 * 메뉴
		 * 1. 학생 등록
		 * 2. 성적 수정
		 * 3. 성적 확인
		 * 4. 종료
		 * 메뉴 선택 : 
		 * */
		
		/* 메뉴를 출력하고 메뉴를 콘솔창에서 입력 받는 코드를 작성하세요.
		 * 단, 입력받은 메뉴가 4가 아니면 반복하도록 작성하세요. */
		
		/* 입력한 메뉴가 1이면 학생 등록입니다. 2이면 성적 수정입니다. 3이면 성적 확입니다. 4이면 프로그램종료입니다.
		 * 라고 출력하도록 코드를 작성하세요. */
		
		/* 프로그램 관리를 위한 Student 클래스를 추가하세요.
		 * - 학년, 반, 번호, 이름, 국어, 영어, 수학 
		 * - 멤버변수는 private 으로 하고 getter/setter 를 추가
		 * - 기본 생성자와 학년, 반, 번호, 이름을 이용한 생성자를 추가
		 * - 국어, 영어, 수학 성적을 변경하는 기능을 추가 */
		
		/* 학생 등록 기능을 구현사세요.
		 * 학년, 반, 번호, 이름을 입력받아 학생을 추가하세요.
		 * */
		
		Scanner scan = new Scanner(System.in);
		// 학생 배열
		Student[] list = new Student[10];
		int studentCount = 0; // 저장된 학생 수
		boolean isTrue = false;
		int kor, eng, math;
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			//runMenu(menu);
			switch (menu) {
			case 1:
				if (studentCount == list.length) {
					System.out.println("다 찼습니다.");
					break;
				}
				// 학년, 반, 번호, 이름을 입력 방고
				System.out.print("학년 : ");
				int grade = scan.nextInt();
				System.out.print("반 : ");
				int classNum = scan.nextInt();
				System.out.print("번호 : ");
				int num = scan.nextInt();
				System.out.print("이름 : ");
				String name = scan.next();
				
				// 입력받은 정보를 이용하여 학생 객체를 생성
				// 배열이 꽉 차지 않으면 생성한 학생 객체를 배열에 저장하고
				list[studentCount] = new Student(grade, classNum, num, name);
					
				// 저장된 학생수를 1증가
				studentCount++;
				for(Student tmp : list) {
					if(tmp != null) {
						System.out.println(tmp.getName());
					}
				}
				break;
			case 2:
				// 학년, 반, 번호를 입력
				System.out.print("학년 : ");
				grade = scan.nextInt();
				System.out.print("반 : ");
				classNum = scan.nextInt();
				System.out.print("번호 : ");
				num = scan.nextInt();
				
				int count = 0;
				// 입력받은 학년, 반, 번호를 이용하여 일치하는 학생이 있는지 확인
				for (int i = 0; i < list.length; i++) {
					if (list[count].getGrade() == grade && list[i].getClassNum() == classNum && list[i].getNum() == num) {
						isTrue = true;
						break;
					}
					count++;
				}
				// 없다면 일치하는 학생이 없다고 출력하고 종료
				if (!isTrue) {
					System.out.println("일치하는 학생이 없습니다.");
					break;
				}
				// 있다면 국어, 영어, 수학 성적을 입력받아 학생 성적을 수정
				else {
					System.out.println("국어 성적 : ");
					kor = scan.nextInt();
					System.out.println("영어 성적 : ");
					eng = scan.nextInt();
					System.out.println("수학 성적 : ");
					math = scan.nextInt();
					list[count].updateScore(kor, eng, math);
				}
				break;
			case 3:
				// 학년, 반, 번호를 입력
				
				// 입력받은 학년, 반, 번호를 이용하여 일치하는 학생이 있는지 확인
				
				// 없다면 일치하는 학생이 없다고 출력하고 종료
				
				// 있다면 해당 학생의 성적을 출력
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		} while(menu != 4);
		
	}

	/* 기능 : 메뉴를 출력하는 메소드 */
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 확인");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	/* 기능 : 메뉴에 맞는 기능을 실행하는 메소드 
	 * @param menu 실행할 메뉴 */
	public static void runMenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("학생 등록입니다.");
			break;
		case 2:
			System.out.println("성적 수정입니다.");
			break;
		case 3:
			System.out.println("성적 확인입니다.");
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	public static void studentRegistration(int grade, int classNum, int num, String name) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학년, 반, 번호를 입력하세요 : ");
		grade = sc.nextInt();
		classNum = sc.nextInt();
		num = sc.nextInt();
		System.out.println("이름을 입력하세요. : ");
		name = sc.next();
	}
	
}

class Student {
	
	// 멤버 변수
	// 인스턴스 변수
	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;
	
	// 기본 생성자 (디폴트 생성자)
	public Student() {}
	
	// 생성자
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	/* 기능 : 국어, 영어, 수학 성적이 주어지면 변경하는 메소드
	 * @param kor 국어 성적
	 * @param eng 영어 성적
	 * @param math 수학 성적
	 * */
	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// getters 와 setters
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
	
	
}

