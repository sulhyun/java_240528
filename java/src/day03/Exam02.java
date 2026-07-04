package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생1 성적 입력 : ");
		int score1 = scan.nextInt();
		
		System.out.print("학생2 성적 입력 : ");
		int score2 = scan.nextInt();
		
		System.out.print("학생3 성적 입력 : ");
		int score3 = scan.nextInt();
		
		int total = score1 + score2 + score3;
		double average = (double)total / 3;
		
		System.out.println("총점 : " + total + "점\n평균 : "
							+ average);
		
	}

}
