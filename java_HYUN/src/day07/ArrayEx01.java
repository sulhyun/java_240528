package day07;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {

		/*
		3명의 학생의 국어, 영어, 수학 성적을 입력받고
		각 학생의 평균을 구하는 코드를 작성하세요.
		 */

		Scanner sc = new Scanner(System.in);

		int[][] studentABC = new int[3][3]; 
		char ch = 'A';

		for (int i = 0; i < studentABC.length; i++) {
			System.out.print("학생" + (char)(ch + i) + " 성적을 입력하세요 (국어 영어 수학 순) : ");
			for (int j = 0; j < studentABC[i].length; j++) {
				studentABC[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < studentABC.length; i++) {
			int sum = 0;
			double avg = 0;
			for (int j = 0; j < studentABC[i].length; j++) {
				sum += studentABC[i][j];
			}
			avg = sum / (double)studentABC[i].length;
			System.out.println("학생" + (char)(ch + i) + " 의 평균 : " + avg);
		}                 
	}

}
