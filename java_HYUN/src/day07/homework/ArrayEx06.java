package day07.homework;

import java.util.Arrays;
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
		int sum = 0;
		double avg = 0;
		boolean isFail = false;
		
		System.out.print("성적 입력 : ");
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
		}
		// System.out.println(Arrays.toString(scores));
		for (int tmp : scores) {
			sum += tmp;
		}
		// System.out.println(sum);
		
		avg = sum / (double)scores.length;
		// System.out.println(avg);
		
		for (int tmp : scores) {
			if (tmp < 40) {
				isFail = true;
				break;
			}
		}
		
		if(isFail) {
			System.out.println("Fail");
		}
		else {
			System.out.println("Pass");
		}
	}

}
