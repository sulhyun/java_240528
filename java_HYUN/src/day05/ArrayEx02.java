package day05;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		
		/*
		학생 3명의 성적을 저장하는 배열을 생성하고,
		학생 3명의 성적을 콘솔을 통해 입력받고,
		출력하는 코드를 작성하세요.
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[3];
		
		//System.out.print("3명의 학생의 성적을 입력하세요.");
		for (int i = 0; i < scores.length; i++) {
			System.out.print("학생" + (i+1) + "의 성적 : ");
			scores[i] = sc.nextInt();
		}
		
		for (int i = 0; i < scores.length; i++) {
			System.out.println("학생" + (i+1) + "의 성적 : " + scores[i]);
		}
		
		// 입력받은 성적의 평균을 구하는 코드를 작성하세요.
		
		int sum = 0;
		double average = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		average = (double)sum / scores.length;
		System.out.println(scores.length + "명의 학생의 성적 평균 : " + average);
	}

}
