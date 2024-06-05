package day07;

import java.util.Arrays;

public class ArrayInitializeEx01 {

	public static void main(String[] args) {
		
		int[] arr1 = new int[] {1,2,3,4,5};
		
		System.out.println(Arrays.toString(arr1));
		
		arr1 = new int[] {5,4,3,2,1};
		
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = {3,4,5,6,7};
		
		System.out.println(Arrays.toString(arr2));
		
		// arr2 = {7,6,5,4,3}; 에러 발생. 불가능
		
		/*
		배열 사용
		배열명[번지]를 이용하여 변수처럼 사용할 수 있다.
		번지는 0번지부터 크기 -1번지까지 사용 가능하다.
		잘못된 번지로 접근하면 예외 발생 (ArrayIndexOutOfBoundsException)
		*/
		
		/*
		배열의 길이
		배열명.length 를 사용
		*/
	}

}
