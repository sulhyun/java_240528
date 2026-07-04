package day12;

public class WrapperEx01 {

	public static void main(String[] args) {
				
		// 문자열을 정수로
		String str1 = "123";
		int num = Integer.parseInt(str1);
		System.out.println(num);
		
		// 문자열을 실수로
		String str2 = "3.14";
		double num2 = Double.parseDouble(str2);
		System.out.println(num2);
		
		// 박싱 : int => Integer
		int num4 = 19;		
		Integer num3 = num4;
		System.out.println(num3);
		
		// 언박싱 : Integer => int
		Integer num5 = 19;
		int num6 = num5;
		System.out.println(num6);
	}

}
