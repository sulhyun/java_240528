package day12.homework;

public class HomeWorkEx01 {

	public static boolean isNumber(String str) {
		if (str == null || str == "") {
			return false;
		}
		for(int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if(tmp < '0' || tmp > '9') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
	}

}


