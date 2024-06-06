package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
		
		/*
		2단의 결과값인 2,4,6,8,10,....18을 배열에 저장하고
		배열에 있는 값을 이용하여 구구단 2단을 출력하는 예제
		*/
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (dan * (i + 1));
		}
		
		// System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(dan + " X " + (i + 1) + " = " + arr[i]);
		}
	}

}
