package day03;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		
		/*
		성적을 입력받아 성적에 맞는 학점을 출력하는
		코드를 작성하세요. 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성적을 입력하세요 : ");
		
		int score = sc.nextInt();
		
		// 방법 1
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		} else if (score >= 80 && score < 90) {
			System.out.println("B");
		} else if (score >= 70 && score < 80) {
			System.out.println("C");
		} else if (score >= 60 && score < 70) {
			System.out.println("D");
		} else if (score < 60 && score >= 0) {
			System.out.println("F");
		} else if (score < 0 || score > 100) {
			System.out.println("잘못된 성적입니다.");
		}
		
		// 방법 2 (가독성 더 좋음)
		if (score < 0 || score > 100) {
			System.out.println("잘못된 성적입니다.");
		} else if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
 	}

}
