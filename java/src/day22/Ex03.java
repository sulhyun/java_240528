package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		/* 리스트에 숫자들을 저장하고, 저장된 숫자들을 정렬하는 코드를 작성하세요. */
		
		List<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		// 리스트에 숫자를 저장
		System.out.println("입력 : ");
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		list.add(sc.nextInt());
		
		Collections.sort(list);
		System.out.println(list);
		
		// 졍렬된 숫자들을 역순으로 정렬하는 코드를 작성하세요.
		// Collections.reverse(list); // 요소들을 역순으로 배치
		Collections.sort(list, (i1, i2) -> i2 - i1);
		System.out.println(list);
	}

}
