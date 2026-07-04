package day22;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		/* 콘솔에서 한 문장(영어)을 입력하고 한 문장에 몇 개의 단어로 구성되어 있는지 확인하는
		 * 코드를 작성하세요.
		 * Hi My name is Hong
		 * => 출력값 : 5 */
		
		// 1. 한 문장을 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("한 문장을 입력 : ");
		String sentence = sc.nextLine();
		
		// 2. 입력받은 문장을 공백 기준으로 쪼개서 배열에 저장
		String[] list = sentence.split(" ");
		
		// 3. length를 이용해서 출력
		System.out.println(list.length);
	}

}
