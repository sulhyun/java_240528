package day12;

public class MathEx02 {

	public static void main(String[] args) {
		
		/* 3.14를 소수점 2번째 자리에서 올림하는 코드를 작성하세요. 
		 * 3.2를 만들어라*/
		
		double num = 3.14;
		System.out.println("3.14를 소수점 두번째 자리에서 올림 : " + (Math.ceil(num * 10) / 10));
	}

}
