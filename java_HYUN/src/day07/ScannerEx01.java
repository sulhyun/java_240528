package day07;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		
		/*
		Scanner 를 이용하여 next()와 nextLine()의 차이를
		살펴보는 예제
		next()
		- 문자열.
		- 공백을 제외한 연속된 문자열.
		- 문자열을 입력하기 전 입력 버펴에 엔터가 있으면 버림
		nextLine()
		- 문자열
		- 공백을 포함한 한 줄의 문자열.
		- 문자열을 입력하기 전 입력 버퍼에 엔터가 있으면 가져와서 실행
		- 문자열을 입력한 마지막에 입려한 엔터를 가져가고 가져간 엔터를 버림
		*/
		
		Scanner scan = new Scanner(System.in);
		// next()는 여러변 연속으로 나와도 문제가 없음.
		System.out.print("문자열 입력(nextLine) : ");
		String str1 = scan.nextLine();
		System.out.print("문자열 입력(next) : ");
		String str2 = scan.next();
		scan.nextLine(); // 엔터 제거용
		System.out.print("문자열 입력(nextLine) : ");
		String str3 = scan.nextLine();
		
	}

}
