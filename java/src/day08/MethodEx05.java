package day08;

import java.util.Scanner;

public class MethodEx05 {

	public static void main(String[] args) {
		
		/*
		정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지
		확인하는 코드를 작성하세요.
		단, 메서드를 이용하여 
		*/
		
		int[] nums = {1,2,4,5};
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if (contains(nums, num)) {
			System.out.println(num + "는 있습니다.");
		}
		else {
			System.out.println(num + "는 없습니다.");
		}
	}
	
	/*
	기능 : 정수 배열이 주어지면 배열에 정수 num 가 있는지 없는지 알려주는 메서드
	매개변수 : 정수배열과 정수 num => int[] arr, int num 
	리턴타입 : 정수 num 가 배열에 있는지 없는지 => boolean
	메서드명 : contains
	*/

	public static boolean contains(int[] arr,int num) {
		// 배열이 null 이면 false를 리턴 (예외 방지 코드)
		if (arr == null) {
			return false;
		}
		// 반복문을 이용하여 배열 전체를 탐색
		for (int tmp : arr) {
			// 배열에서 꺼낸 값과 num가 같으면 true를 리턴
			if (tmp == num) {
				return true;
			}
		}
		// 반복문이 끝날때까지 못찾으면 false를 리턴
		return false;
	}
	
}
