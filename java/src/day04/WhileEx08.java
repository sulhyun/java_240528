package day04;

public class WhileEx08 {

	public static void main(String[] args) {
		
		/*
		두 정수 8과 12의 최대 공약수를 구하는 코드를 작성하세요.
		공약수 : 공통으로 있는 약수
		최대 공약수 : 공약수 중 가장 큰 공약수
		8 : 1, 2, 4, 8
		12 : 1, 2, 3, 4, 6, 12
		8과 12의 공약수 : 1, 2, 4
		8과 12의 최대 공약수 : 4
		반복횟수 : i 는 1부터 8까지 1씩 증가
		규칙성 : 
			i 가 8과 12의 약수이면 i 를 gcd 에 저장
			=> i 가 8의 약수이고 i 가 12의 약수이면 i 를 gcd 에 저장
			=> 8을 i 로 나누었을 때 나머지가 0과 같고 12 를 i 로 나누었을 때 나머지가 0과 같다면 i 를 gcd 에 저장
		박복문 종료 후 :
		*/
		
		int i = 1;
		int gcd = 1;
		int num1 = 8, num2 = 12;
		
		while (i <= num1) {
			if(num2 % i == 0) {
				if(num1 % i == 0) {
					gcd = i;
				}
			}
			i++;
		}
		System.out.println(num1 + "," + num2 + 
				" 최대 공약수 : " + gcd);
		
	}

}
