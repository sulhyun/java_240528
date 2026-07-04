package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx01 {
	
	/*
	정수 n을 입력받아 입력받은 n 크기를 가지는 배열을 생성하는
	코드를 작성하세요.
	단, 메서드를 이용하여
	*/
	
	public static void main(String[] args) {
		
		// 정수 입력(배열의 크기)
		Scanner sc = new Scanner(System.in); 
		System.out.print("배열 크기 입력 : ");
		int size = sc.nextInt();
		// 입력 받은 정수를 이용하여 정수 배열을 생성
		
		int[] arr = createArray(size);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = null;
		createArray2(arr2, size);
		System.out.println(Arrays.toString(arr2));
	}

	/*
	기능 : 배열의 크기가 주어지면 주어진 배열 크기의 정수 배열을 생성해서 알려주는 메서드
	매개변수 : 배열 크기 => int size
	리턴타입 : 생성된 정수 배열 => int[]  
	메서드명 : createArray
	*/
	
	public static int[] createArray(int size) {
		if (size < 0) {
			return null;
		}
		return new int[size];
	}
	
	/*
	[잘못된 경우]
	기능 : 배열과 배열의 크기가 주어지면 주어진 배열의 배열 크기의 정수 배열을 생성하는 메서드
	매개변수 : 배열, 배열의 크기 => int[] arr, int size
	리턴타입 : 없음 => void
	메서드명 : createArray2
	*/
	
	public static void createArray2(int[] arr, int size) {
		// =을 통해 기본형 변수나 참조형 변수를 재할당하여 main에 있는 원본이 바뀌지 않는다.
		arr = new int[size];
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
