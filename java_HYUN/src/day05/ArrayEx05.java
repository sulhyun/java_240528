package day05;

import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {
		
		// 1 ~ 10 사이의 랜덤한 수 3개를 저장하고 출력하는 예제
		// 1 3 2
		int[] nums = new int[3];
		final int max = 10, min = 1;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * (max - min + 1) + min);
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		// 숫자를 입력해서 입력한 숫자가 랜덤한 수에 있는 확인하는 예제
		// 출력 예제
		// 8 : 없습니다.
		// 3 : 있습니다.
		
		/*
		방법 1
		반복 횟수 : i 는 인덱스 0부터 배열의 크기보다 작을 때까지 1씩 증가
		규칙성 : 배열 인덱스 i 에 있는 값과 입력받은 값이 같으면 반복문을 종료
		반복문 종료 후 : i 가 배열의 크기보다 작으면 ~은 있습니다. 라고 출력하고 같으면 ~은 없습니다.라고 출력
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (num == nums[i]) {
				break;
			}
		}
		if (i < nums.length) {
			System.out.println(num + " : 있습니다.");
		} else if (i == nums.length) {
			System.out.println(num + " : 없습니다.");
		}
		
		System.out.println("for 문 활용 #1\n");
		
		/*
		방법 2
		반복 횟수 : 향상된 for 문을 이용하여 전체 탐색
		규칙성 : 배열의 값과 입력받은 값이 같으면 boolean result 를 true 로 변경하고, 반복문을 종료
		반복문 종료 후 : result 가 true 이면 ~은 있습니다. 라고 출력하고 아니면 ~은 없습니다.라고 출력
		 */
		boolean result = false;
		System.out.print("정수를 입력하세요 : ");
		num = sc.nextInt();
		for (int j : nums) {
			if (num == j) {
				result = true;
				break;
			}
		}
		if (result) {
			System.out.println(num + " : 있습니다.");
		} else {
			System.out.println(num + " : 없습니다.");
		}
		
		System.out.println("향상된 for 문 활용 #2");

	}

}
