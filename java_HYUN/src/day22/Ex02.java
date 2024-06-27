package day22;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		/* 콘솔에서 정수로 이루어진 문자열을 입력받아 각 정수들의 합을 구하는 코드를 작성하세요.
		 * 1 23 45 3 9 7 5
		 * 93
		 * */
		
		Scanner sc= new Scanner(System.in);
		
		
		// 정수로 이루어진 문자열을 입력을 받는다 (문자열에 개수는 정해지지 않음)
		System.out.print("입력 : ");
		String num = sc.nextLine();
		int sum = convertAndSum(num);
		System.out.println(sum);
	}
	
	/* 위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때 필요하다고 생각하는 코드를
	 * 메소드로 만들어 보세요. */
	
	public static String[] arraySplit(String num) {
		String[] nums = num.split(" ");  
		return nums;
	}
	
	public static int arraySum(String[] nums) {
		int sum = 0;
		for (String tmp : nums) {
			 sum += Integer.parseInt(tmp);
		}
		return sum;
	}

	/** 주어진 문자열에 있는 정수들을 더해서 더한 결과를 반환하는 메소드
	 * @param num 정수들이 있는 문자열 
	 * @return 문자열에 있는 정수들의 합
	 */
	public static int convertAndSum(String num) {
		String[] nums = arraySplit(num); 
		System.out.println(Arrays.toString(nums));
		int sum = arraySum(nums);
		return sum;
	}
}
