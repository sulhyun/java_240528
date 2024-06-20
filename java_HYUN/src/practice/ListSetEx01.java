package practice;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ListSetEx01 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		/* 숫자 야구 게임을 구현하세요. 
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자가 있고 위치가 다른 경우
		 * O : 일치하는 숫자가 하나도 없는 경우
		 * */
		
		List<Integer> com = new ArrayList<Integer>();
		List<Integer> user = new ArrayList<Integer>();
		
		int min = 1, max = 9, count = 3;
		
		com = createRandom(min, max, count);
		
		System.out.println(com);
		
		int s, b;
		do {
			System.out.print("정수 입력 : ");
			user = InputUser(count);
			
			s = getStrike(com, user);
			b = getBall(com, user);
			
			if (s != 0) {
				System.out.print(s + "S");
			}
			if (b != 0) {
				System.out.print(b + "B");
			}
			if (s == 0  && b == 0) {
				System.out.print("O");
			}
			System.out.println();
		}while(s != count);
		System.out.println("정답입니다.");
	}

	private static int getBall(List<Integer> com, List<Integer> user) {
		int b = 0;
		for (Integer tmp : com) {
			if(user.contains(tmp)) {
				b++;
			}
		}
		return b - getStrike(com, user);
	}

	private static int getStrike(List<Integer> com, List<Integer> user) {
		int s = 0;
		for (int i = 0; i < com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				s++;
			}
		}
		return s;
	}

	private static List<Integer> InputUser(int count) {
		List<Integer> tmp = new ArrayList<Integer>();
		while(tmp.size() != count) {
			int num = sc.nextInt();
			if(!tmp.contains(num)) {
				tmp.add(num);
			}
		}
		return tmp;
	}

	private static List<Integer> createRandom(int min, int max, int count) {
		if (min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		
		if(max - min + 1 < count) {
			String format = "{0}~{1} 사이에서 중복되지 않은 {2}개의 수를 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min, max, count));
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(set.size() != count) {
			set.add((int)(Math.random() * (max - min - 1) + min));
		}
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.addAll(set);
		Collections.shuffle(list);
		
		return list;
	}

}
