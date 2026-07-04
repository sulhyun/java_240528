package day05;

public class LCMEx01 {

	public static void main(String[] args) {
		
		/*
		두 정수의 최소 공배수를 구하는 코드를 작성하세요. 
		A 의 배수 B : B를 A로 나누었을때 나머지가 0인 B를 A의 배수라고 표현
		6의 배수 : 6, 12, 18, 24, 30, ...
		8의 배수 : 8, 16, 24, 32, 40, ...
		공배수 : 두 수의 배수 중 공통으로 있는 수
		6과 6의 공배수 : 24, 48, 72, ...		
		최소 공배수 : 두 수의 공배수 중 가장 작은 수
		6과 8의 최소 공배수 : 24
		
		반복횟수 : i는 1부터 무한대까지 1씩 증가
		규칙성 : i 가 num1 의 배수이고 i 가 num2의 배수이면 i 를
			출력하고 반복문을 종료
			=> i 를 num1 로 나누었을 때 나머지가 0과 같고 i를 num2로 
				나누었을 때 나머지가 0과 같다면 i를 출력 후 종료
		반복문 종료 후 : 없음
		*/
		
		// (for 문) 이용
		int num1 = 6, num2 = 8;
		for (int i = 1; ; i++) {
			if (i % num1 == 0) {
				if (i % num2 == 0) {
					System.out.println(num1 + ", " + num2 +
							"의 최소 공배수 : " + i);
					break;
				}
			}
			
		}
		
		// (while 문) 이용
		int i = 1;
		while(true) {
			if (i % num1 == 0) {
				if (i % num2 == 0) {
					System.out.println(num1 + ", " + num2 +
							"의 최소 공배수 : " + i);
					break;
				}
			}
			i++;
		}
		
		/*
		반복횟수 : i 는 num1부터 무한대까지 num1씩 증가 => i 는 num1의 배수들만 사용 
		규칙성 : i 는 num2의 배수이면 i 를 출력하고 반복문 종료
		반복문 종료 후 : 없음
		
		num1이 num2보다 작으면 num1과 num2를 바꾸는 코드
		num1이 111이고 num2가 30000이면 num1 30000으로 num2를 111로 수정하는 코드
		*/
		
		
		num1 = 111;
		num2 = 30000;
		int tmp;
		
		// num2 이 num1보다 크다면 서로 위치 바꾸는 코드
		if (num1 < num2) {
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		// 더 효율성 좋은 코드
		for (i = num1; ; i += num1) {
			if (i % num2 == 0) {
				System.out.println(num1 + ", " + num2 +
						"의 최소 공배수 : " + i);
				System.out.println(num1 + "," + num2);
				break;
			}
		}
				
	}

}
