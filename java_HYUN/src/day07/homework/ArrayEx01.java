package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		
		/*
		3명의 학생의 국어, 영어, 수학 성적을 입력받고
		각 학생의 평균을 구하는 코드를 작성하세요.
		*/
		
		Scanner sc = new Scanner(System.in);
		int studentCnt = 3;
		
		int[] kor = new int[studentCnt];
		int[] eng = new int[studentCnt];
		int[] math = new int[studentCnt];
		
		for (int i = 0; i < studentCnt; i++) {
			System.out.print("학생" + (i + 1) + "의 성적 입력 (국어, 영어, 수학 순) :");
			kor[i] = sc.nextInt();
			eng[i] = sc.nextInt();
			math[i] = sc.nextInt();
		}
		
		for (int i = 0; i < studentCnt; i++) {
			int sum = kor[i] + eng[i] + math[i];
			double avg = sum / (double)studentCnt;
			System.out.println("학생" + (i + 1) + "의 성적 평균 : " + avg);
		}
		System.out.println();
		
		/*
		각 과목의 평균을 구하는 코드를 작성하세요.
		출력 예제
		국어 평균 : ...
		영어 평균 : ...
		수학 평균 : ...
		*/
		
		// 과목 평균 구하기 (방법1)
		
		// 국어 평균
		int sum = 0;
		for (int tmp : kor) {
			sum += tmp;
		}
		double avg = sum /(double)kor.length;
		System.out.println("국어 평균 : " + avg);
		// 영어 평균
		sum = 0;
		for (int tmp : eng) {
			sum += tmp;
		}
		avg = sum /(double)eng.length;
		System.out.println("영어 평균 : " + avg);
		// 수학 평균
		sum = 0;
		for (int tmp : math) {
			sum += tmp;
		}
		avg = sum /(double)math.length;
		System.out.println("수학 평균 : " + avg);
		
		// 과목 평균 구하기 (방법2)
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for (int i = 0; i < studentCnt; i++) {
			sum1 += kor[i];
			sum2 += eng[i];
			sum3 += math[i];	
		}
		
		double avg1 = sum1 / (double)kor.length;
		double avg2 = sum2 / (double)eng.length;
		double avg3 = sum3 / (double)math.length;
		
		System.out.println("국어 평균 : " + avg1);
		System.out.println("영어 평균 : " + avg2);
		System.out.println("수학 평균 : " + avg3);
	}

}
