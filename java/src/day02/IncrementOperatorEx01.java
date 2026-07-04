package day02;

public class IncrementOperatorEx01 {
	// 증감 연산자 예제
	public static void main(String[] args) {
		
		// 증감 연산자(++, --)
		/*
		최종적으로 변수가 1증가/1감소
		위치에 따라 전위형/후위형으로 나뉨
		++변수 : 전위형, 증가하고 실행
		변수++ : 후위형, 실행하고 증가
		전위형 후위형 헷갈리면 둘 중 한가지 방법만 통일해서 쓰자!!
		 */
		
		int num1 = 10, num2 = 10;
		
		++num1;
		num2++;
		
		System.out.println("num1 : " + num1);
		System.out.println("num1 : " + num2);
		
		System.out.println("증가 전 num1 : " + num1);
		System.out.println("증가 전 num2 : " + num2);
		
		System.out.println("증가 중 num1 : " + ++num1); // 전위형
		System.out.println("증가 중 num2 : " + num2++); // 후위형
		
		System.out.println("증가 후 num1 : " + num1);
		System.out.println("증가 후 num2 : " + num2);
	}

}
