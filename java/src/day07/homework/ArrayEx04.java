package day07.homework;

import java.util.Arrays;
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
		int[] nums = new int[4];

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int i = 0;

		if (num < 1000 || num > 9999 ) {
			System.out.println("잘못된 값입니다.");

		}
		else {			
			while (num != 0) {
				nums[i++] = num % 10;
				num = num / 10;
			}

		}
		System.out.print("정수 역순 : ");
		for (int tmp : nums) {
			System.out.print(tmp);
		}
		
	}

}
