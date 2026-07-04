package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Ex03 {

	public static void main(String[] args) {
		
		/* 1~10 사이의 랜덤한 수 6개를 중복되지 않게 생성해서 저장하고 출력하는 코드를 작성하세요. */
		
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		final int MAX = 10;
		final int MIN = 1 ;
		
		while(set.size() != 6) {
			int random = (int)(Math.random() * (MAX - MIN + 1)) + MIN;
			set.add(random);
		}
		
		list.addAll(set);
		
		Collections.shuffle(list);
		
		System.out.println(list);
	}

}
