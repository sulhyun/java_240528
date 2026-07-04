package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("과목1 성적 입력 : ");
		int sub1 = scan.nextInt();
		
		System.out.print("과목1 성적 입력 : ");
		int sub2 = scan.nextInt();
		// 총점
		int total = sub1 + sub2;
		// 평균
		double avg = (double)total / 2;
		// 40점 미만 과락 여부 확인
		boolean isFail = sub1 < 40 || sub2 < 40;
		// 3항 연산자로 합격 불합격 여부 확인
		String pass = (avg >= 60 && !isFail) ? "합격" : "불합격";
		// 출력문
		System.out.println("결과 : " + pass);
	}

}
