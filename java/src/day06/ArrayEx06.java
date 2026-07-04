package day06;

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
		4. 과락 여부 확인
		5. 과락이 아니고 평균이 60점 넘은 Pass 출력 (아니면) Fail 출력
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] scores = new int[4];
		
		System.out.print("성적을 입력하세요 : ");
		// 4과목의 성적을 입력받아 배열에 저장
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
		}
		//성적의 합 구하기
		int sum = 0;
		for (int tmp : scores) {
			sum += tmp;
		}
		// 성적의 합으로 평균을 구하기
		double avg = (double)sum / scores.length;
		
		// 과락의 여부 확인
		boolean isFail = false;
		for (int tmp : scores) {
			if(tmp < 40) {
				isFail = true;
				break;
			}
		}
		
		if (!isFail && avg >= 60) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
		sc.close();
	
	}

}
