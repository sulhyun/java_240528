package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		
		String[] list = {"dog", "cat", "java", "cup", "computer"};
		
		/*
		문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는
		코드를 작성하세요.
		*/
		
		Scanner sc = new Scanner(System.in);
		boolean isTrue = false;
		System.out.print("문자열 입력 : ");
		String st = sc.next();

		for (String tmp : list) {
			if (tmp.equals(st)) {
				isTrue = true;
				break;
			}
		}
		
		if(isTrue) {
			System.out.println("있습니다.");
		}
		else {
			System.out.println("없습니다.");
		}
	}

}
