package day06.homwork;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		
		/*
		4과목의 성적을 입력받아 배열에 저장하고,
		과락이 없고 평균이 60점이 넘으면 Pass
		아니면 Fail라고 출력하세요.
		*/
		
		/*
		1. 4과목의 성적을 입력받아 배열에 저장.
		2. 성적의 합을 구하기.
		3. 성적의 합으로 평균을 구하기.
		4. 과락 여부 (40점 미만) 확인
		5. 과락이 아니고 평균이 60점 넘은 Pass 출력 (아니면) Fail 출력
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[4];
		int sum = 0;
		double avg = 0;
		boolean isFail = false;
		
		for (int i = 0; i < score.length; i++) {
			System.out.print("성적 입력 : ");
			int num = sc.nextInt();
			score[i] = num;
		}
		
		for (int tmp : score) {
			sum += tmp;
		}
		
		avg = sum / (double)score.length;
		
		for (int tmp : score) {
			if (tmp < 40) {
				isFail = true;
			}
		}
		
		if(!isFail && avg >= 60) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}

}
