package day07.homework;

import java.util.Arrays;

public class ArrayEx02 {

	public static void main(String[] args) {
		
		/*
		1 ~ 9 사이의 랜덤한 수 3개를 배열에 저장하는데
		중복되지 않게 저장하는 코드를 작성해보세요.
		*/
		
		int[] nums = new int[3]; // 배열
		final int MAX = 9, MIN = 1; // 랜덤에 저장할 수의 범위
		int count = 0; // 배열에 저장할때 1씩 올라가는 변수
		int i; // for문에서 선언되면 바깥에서는 사용할 수 없음
		
		while (count < nums.length) { // 카운트가 배열에 마직막 인덱스와 값이 같아지면 탈출
			int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			
			for (i = 0; i < count; i++) {
				if(nums[i] == random) {
					break;
				}
			}
			
			if (i == count) {
				nums[count] = random;
				count++;
			}
			System.out.println(random); // 랜덤이 몇번 값을 내보냈지는 알려주는 출력문
		}
		System.out.println(Arrays.toString(nums));
		

	}

}
