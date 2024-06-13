package day12.homework;

public class HomeWorkEx02 {

	public static int max(int[] data) {
		if(data == null || data.length == 0) {
			return -999999;
		}
		
		int tmp = data[0];
		for(int i = 0; i < data.length; i++) {
			tmp = tmp >= data[i] ? tmp : data[i];
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		
		int[] data = {3,2,9,4,7}; // 크기가 5인 int형 배열 
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최댓값 : " + max(data));
		System.out.println("최대값 : " + max(null));
		System.out.println("최대값 : " + max(new int[] {})); // 크기가 0인 int형 배열
	}

}
