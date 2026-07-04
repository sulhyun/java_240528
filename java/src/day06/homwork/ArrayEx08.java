package day06.homwork;

import java.util.Arrays;
import java.util.Collections;

public class ArrayEx08 {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,3,5,7,9,2,4,6,8,10};
		
		/*
		1 3 5 7 9 2 4 6 8 10
		1 3 5 7 2 4 6 8 9 10 (i = 0) 제일 큰수 10
		1 3 5 2 4 6	7 8	9 10 (i = 1) 2번째로 큰수 9
		1 3 2 4 5 6 7 8 9 10 (i = 2) 3번째로 큰수 8
		1 2 3 4 5 6 7 8 9 10 (i = 3) 4번째로 큰수 7
				.			 (i = 4)
				.			 (i = 5)
				.			 (i = 6)
				.			 (i = 7)
		1 2 3 4 5 6 7 8 9 10 (i = 8) 제일 작은 수 1
			필요 없는 식		 (i = 9)
							 
		*/
		
		// 버블 정렬
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

		arr = new int[] {1,3,5,7,9,2,4,6,8,10};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		arr = new int[] {1,3,5,7,9,2,4,6,8,10};
		
		Arrays.sort(arr, 0, 10);
		System.out.println(Arrays.toString(arr));
		
		Integer[] arr1 = new Integer[] {1,3,5,7,9,2,4,6,8,10};
		
		Arrays.sort(arr1, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr1));
	}

}
