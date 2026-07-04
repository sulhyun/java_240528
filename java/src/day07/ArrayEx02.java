package day07;

import java.util.Arrays;

public class ArrayEx02 {

	public static void main(String[] args) {
		
		/*
		1 ~ 9 사이의 랜덤한 수 3개를 배열에 저장하는데
		중복되지 않게 저장하는 코드를 작성해보세요.
		*/
		int[] arr = new int[3];
		int max = 9, min = 1;
		int count = 0;
		int i;
		while (count < 3) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			
			for (i = 0; i < count; i++) {
				if(arr[i] == random) {
					break; // break 를 만나면 i 는 count 보다 작을 수 밖에 없음
				}
			}
			
			if (i == count) {
				arr[count] = random;
				count++;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}
