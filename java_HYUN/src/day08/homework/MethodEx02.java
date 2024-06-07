package day08.homework;

import java.util.Arrays;

public class MethodEx02 {

	/*
	1~9사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는
	코드를 작성하세요.
	단, 메서드를 이용하여
	*/
	
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		arr = randArray(arr);
		
		System.out.println(Arrays.toString(arr));
		
		
	}

	/*
	기능 : 1~9사이의 랜덤한 수를 배열에 저장
	매개변수 : int[] arr
	리턴타입 : int[]
	메서드명 : randArray
	*/
	
	public static int[] randArray(int[] arr) {
		final int MAX = 9, MIN = 1;
		
		for (int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * (MAX - MIN + 1) + MIN);
			arr[i] = random;
		}
		
		return arr;
	}
}
