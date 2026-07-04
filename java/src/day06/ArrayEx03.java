package day06;

import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
		
		/*
		2단의 결과값인 2,4,6,8,10,....18을 배열에 저장하고
		배열에 있는 값을 이용하여 구구단 2단을 출력하는 예제
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[9];
		
		System.out.print("단을 입력하세요 : ");
		int dan = sc.nextInt();
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = dan * (i + 1); 
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(dan + " X " + (i + 1) + " = "
					+ nums[i]);
		}
		System.out.println();
		
		// 10개짜리 배열을 만들어서 0번지를 사용하지 않고 1부터 부터 사용
		int[] nums2 = new int[10];
		System.out.print("단을 입력하세요 : ");
		int dan2 = sc.nextInt();
		
		for (int i = 1; i < nums2.length; i++) {
			nums2[i] = dan2 * i;
		}
		
		for (int i = 1; i < nums2.length; i++) {
			System.out.println(dan2 + " X " + i + " = "
					+ nums2[i]);
		}
		sc.close();
	}

}
