package day02;

public class StringEx02 {

	public static void main(String[] args) {

		// 문자열 + 기본형 => 문자열
		// 기본형 + 문자열 => 문자열
		
		String str1 =1 + "안녕2"; // 기본형 + 문자열
		String str2 = "1안녕" + 2; // 문자열 + 기본형
		
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = 1 + 2 + "3";
		String str4 = "1" + 2 + 3;
		
		System.out.println(str3);
		System.out.println(str4);
	}

}
