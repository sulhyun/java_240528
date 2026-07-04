package day08;

public class MethodEx02 {
	
	/*
	두 수의 최대 공약수와 최소 공배수를 구하는 코드를 작성하세요.
	단, 메서드 이용.
	*/

	public static void main(String[] args) {
		
		System.out.println(gcd(8, 12));
		System.out.println(lcm(8, 12));
		System.out.println(lcm2(8, 12));
		
	}
	
	/*
	정수 num1이 정수 num2의 약수인지 아닌지 알려주는 메서드
	매개변수 : long num1, long num2
	리턴타입 : boolean
	메서드명 : isDivisor
	*/
	
	public static boolean isDivisor(long num1, long num2) {
		
		return num1 % num2 == 0;  
	}
	
	/*
	정수 num1과 정수 num2의 최대 공약수를 알려주는 메서드
	매개변수 : int num1, int num2
	리턴타입 : int
	메서드명 :	gcd
	*/
	
	public static int gcd(int num1, int num2) {
		
		if (num1 > num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		for (int i = num1; i >= 1; i--) {
			// i가 공약수이면
			if(isDivisor(num1, i) && isDivisor(num2, i)) {
				return i;
			}
		}
		return 1;
	}

	
	/*
	정수 num1과 정수 num2의 최소 공배수를 알려주는 메서드
	매개변수 : int num1, int num2
	리턴타입 : long
	메서드명 : lcm
	*/
	
	public static long lcm(int num1, int num2) {
		
		for(long i = num1; i <= num1 * (long)num2; i += num1) {
			
			if(isDivisor(i,num2)) {
				return i;
			}
		}
		return num1 * num2;
	}

	
	/*
	정수 num1과 정수 num2의 최소 공배수를 알려주는 메서드
	매개변수 : int num1, int num2
	리턴타입 : long
	메서드명 : lcm2
	*/
	
	/*
	g : 최대공약수
	A : ga, B : gb
	l : 최소공배수
	l = gab = A * B / g
	*/
	
	public static long lcm2(int num1, int num2) {
		
		return num1 * (long)num2 / gcd(num1, num2);
	}


}
