package day08.homework;

import java.util.Arrays;

public class MethodEx02 {

	/*
	1~9사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는
	코드를 작성하세요.
	단, 메서드를 이용하여
	*/
	
	public static void main(String[] args) {
		
		System.out.println(random(1, 3));
		
		int size = 5;
		int[] arr = createRandomArray(size, 1, 9);
		System.out.println(Arrays.toString(arr));
		
		
	}

	/*
	기능 : 최소값과 최대값 사이의 랜덤한 정수를 생성해서 알려주는 메서드
	매개변수 : 최소값과 최대값 => int max, int min
	리턴타입 : 랜덤한 정수 => int
	메서드명 : random
	*/
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	/*
	기능 : 배열의 크기와 최대값과 최소값이 주어졌을 때, 랜담한 배열을 만들어서 알려주는 메서드
	매개변수 : 배열의 크기, 최대값과 최소값 => int size, int min, int max
	리턴타입 : 랜덤한 정수가 들어있는 배열 => int[]
	메서드명 : createRandomArray
	*/
	
	public static int[] createRandomArray(int size, int min, int max) {
		if (size < 0) {
			return null;
		}
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = random(min, max);
		}
		return arr;
	}
}
