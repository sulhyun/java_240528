package day07.homework;

public class ArrayEx05 {

	public static void main(String[] args) {
		
		/*
		100이하의 소수를 찾는 예제 : 에라토스테네스의 체
		1(x) 2 3 4(x) 5 6(x) 7 8(x) 9(x) 10(x)
		(힌트) 배열은 초기화를 하지 않으면 각 번지에 0 이 자동으로 초기화 됨
		소수 : 0 , 소수 아님(x) : 1
		*/
		
		int[] nums = new int[101];
		
		nums[0] = 1;
		nums[1] = 1;
		
		for (int i = 2; i < nums.length; i++) {
			
			if (nums[i] == 1) {
				continue;
			}
			
			for (int j = i * 2; j < nums.length; j += i) {
				nums[j] = 1;
			}
		}
		
		for (int i = 2; i < nums.length; i++) {
			
			if(nums[i] == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	
	}

}
