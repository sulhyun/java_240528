package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {

		/* 1~10 사이의 랜덤한 수 6개를 중복되지 않게 생성해서 저장하고 출력하는 코드를 작성하세요. */
		
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int min = 1, max = 10;
		int count = 6;
		
		while(set.size() != count) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			set.add(random);
		}
		
		list.addAll(set);
		Collections.shuffle(list);
		
		System.out.println(list);
	}

}
