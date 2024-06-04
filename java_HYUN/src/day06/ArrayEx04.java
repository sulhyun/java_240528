package day06;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		
		/*
		4자리 정수를 입력받아 입력받은 정수를 역순으로 배열에 저장하고,
		출력하는 코드를 작성하세요.
		1234 => 0번지 4, 1번지 3, 2번지 2, 3번지 1 저장하고,
		4,3,2,1 순으로 출력
		*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr1 = new int[4];
		
		// 4자리 정수 입력
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		// 4자리 정수가 아니면 잘못입력됐다고 출력
		if (1000 > num || 9999 < num) {
			System.out.println("4자리 정수가 아닙니다.");
		}
		// 4자리 정수이면
		else {
//			for (int i = 0; i < arr1.length; i++) {
				// 역순으로 배열에 저장
//				arr1[i] = num % 10;
//				num = num / 10; 
//			}
			int tmp = num;
			int i = 0;
			while (tmp != 0) {
				arr1[i++] = tmp % 10;
				tmp = tmp / 10;
			}
		}
		// 배열에 값을 순차적으로 출력
		System.out.print("정수 역순 : ");
		for (int i : arr1) {
			System.out.print(i);
		}
			
		sc.close();
	}

}
