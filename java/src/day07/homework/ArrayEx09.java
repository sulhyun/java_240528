package day07.homework;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		
		String[] list = {"dog", "cat", "java", "cup", "computer"};
		
		/*
		문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는
		코드를 작성하세요.
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String word = sc.next();
		boolean isTrue = false;
		for (int i = 0; i < list.length; i++) {
			if (word.equals(list[i])) {
				isTrue = true;
				break;
			}
		}
		
		if(isTrue) {
			System.out.println("있습니다. (O)");
		}
		else {
			System.out.println("없습니다. (X)");
		}
	}

}
