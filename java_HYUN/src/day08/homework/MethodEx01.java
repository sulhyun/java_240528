package day08.homework;

import java.util.Arrays;

public class MethodEx01 {
	
	/*
	정수 n을 입력받아 입력받은 n 크기를 가지는 배열을 생성하는
	코드를 작성하세요.
	단, 메서드를 이용하여
	*/
	
	public static void main(String[] args) {
		
		int[] arr = createArray(5);
		
		System.out.println(Arrays.toString(arr));
	}

	/*
	기능 : 정수 n을 입력받아 입력받은 n 크기를 가지는 배열을 생성
	매개변수 : 정수 n => int n
	리턴타입 : int[] 
	메서드명 : createArray
	*/
	
	public static int[] createArray(int n) {
		
		return new int[n];
	}
	
}
