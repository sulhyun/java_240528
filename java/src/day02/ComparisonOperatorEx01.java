package day02;

public class ComparisonOperatorEx01 {

	public static void main(String[] args) {
		
		// 비교(관계) 연산자
		/*
		값의 크기를 비교하는 연산자
		>,<,>=,<=,==,!=
		항을 같은 타입으로 변환 후 비교
		결과 값은 true 또는 false
		참조형에는 ==, != 만 사용 가능
		문자열은 ==로 비교하면 안됨 : 문법적으로는 에러가 발생하지는
		않지만 두 문자열이 같은지 다를지를 제대로 비교하진 않음
		*/
		
		// 비교 연산자 예제
		int num1 = 10, num2 = 20;
		// 비교 연산자 결과는 true 또는 false
		System.out.println("" + num1 + '<' + num2 + " : " + (num1 < num2));
		System.out.println("" + num1 + '>' + num2 + " : " + (num1 > num2));
		System.out.println("" + num1 + "<=" + num2 + " : " + (num1 <= num2));
		System.out.println("" + num1 + ">=" + num2 + " : " + (num1 >= num2));
		System.out.println("" + num1 + "==" + num2 + " : " + (num1 == num2));
		System.out.println("" + num1 + "!=" + num2 + " : " + (num1 != num2));
		
		String str1 = "abc", str2 = "abc", str3 = new String("abc");
		// 문자열을 ==, != 을 이용하면 같은 주소인지를 비교하기 때문에 문자열이 같아도 다르다고 판별할 수 있다.
		System.out.println("str1 == str2 : " + (str1 == str2)); // 같은 리터럴을 저장하기 때문에 주소가 같음
		System.out.println("str1 == str3 : " + (str1 == str3)); // str3은 리터럴이 아닌 방법으로 저장하기 때문에 주소가 다름 
		System.out.println("str2 == str3 : " + (str2 == str3)); // str3은 리터럴이 아닌 방법으로 저장하기 때문에 주소가 다름
		// 문자열은 equals 를 이용하여 비교해야 함
		System.out.println("str1 == str2 : " + (str1.equals(str2)));
		System.out.println("str1 == str3 : " + (str1.equals(str3)));
		System.out.println("str2 == str3 : " + (str2.equals(str3)));
	}

}
