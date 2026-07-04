package day12;

import java.util.regex.Pattern;

public class RegexEx01 {

	public static void main(String[] args) {
		
		/* 정규표현식 (웹 회원가입에서 많이 쓰임)(중요)
		 * (문자열이 특정 패턴에 맞는지 확일할 때 사용)
		 * 예) 영문자와 숫자 5~8자리
		 * => ^\w{5,8}$
		 * 예) 영문자와 숫자, 특수문자(!@#?) 5~8자리
		 * => [a-zA-Z0-9!@#?]{5,8}
		 * 예) http:// 또는 https://
		 * => ^(http://|https://)
		 * => ^https?://
		 * */
		
		String regex1 = "^\\w{5,8}$";
		String str1 = "abc123";
		System.out.println(str1 + "은 정규표현식" + regex1 + "에 맞습니까? " + Pattern.matches(regex1, str1));
		
		String str2 = "abc123!";
		System.out.println(str2 + "은 정규표현식" + regex1 + "에 맞습니까? " + Pattern.matches(regex1, str2));
		
		String regex2 = "[a-zA-Z0-9!@#?]{5,8}";
		System.out.println(str2 + "은 정규표현식" + regex2 + "에 맞습니까? " + Pattern.matches(regex2, str2));
		
		String regex3 = "^(http://|https://)";
		String str3 = "http://";
		System.out.println(str3 + "는 http:// 또는 https://로 시작합니까? " + Pattern.matches(regex3, str3));
		
		String regex4 = "^https?://";
		System.out.println(str3 + "는 http:// 또는 https://로 시작합니까? " + Pattern.matches(regex4, str3));
	}

}
