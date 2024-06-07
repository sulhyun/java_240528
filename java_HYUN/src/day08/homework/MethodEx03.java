package day08.homework;

import java.util.Arrays;

public class MethodEx03 {
	
	/*
	배열에 랜덤으로 1~9 사이의 중복되지 않은 배열을 생성하고 콘솔에
	출력하는 코드를 작성하세요.
	단, 메서드 이용하여
	day08.homework.Method01, day08.homework.methodEx02, 
	day08.MethodEx05를 합친 예제
	*/
	
	public static void main(String[] args) {
		int[] arr = duplicateArray(5);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	/*
	기능 : 배열에 랜덤으로 1~9 사이의 중복되지 않은 배열을 생성
	매개변수 : int n
	리턴타입 : int[]
	메서드명 : duplicateArray
	*/
	
	public static int[] duplicateArray(int n) {
		return randArray(createArray(n));
	}

	public static int[] createArray(int n) {
		
		return new int[n];
	}
	
	public static int[] randArray(int[] arr) {
		final int MAX = 9, MIN = 1;
		int count = 0;
		
		while (count < arr.length) {
			int random = (int)(Math.random() * (MAX - MIN + 1) + MIN); 
			if(!contains(arr, random)) {
				arr[count] = random;
				count++;
			}
		}
		return arr;
	}
	
	public static boolean contains(int[] arr,int num) {
		if (arr == null) {
			return false;
		}
		for (int tmp : arr) {
			if (tmp == num) {
				return true;
			}
		}
		return false;
	}
}
