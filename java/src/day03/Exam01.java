package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("성적 입력 : ");
		int score = scan.nextInt();
		String pass = (score >= 60) ? "Pass" : "Fail";
		System.out.println(score + "점은 " + pass);
		
	}

}
