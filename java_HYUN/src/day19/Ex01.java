package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		/* 리스트에 문자열을 5개 입력받아 저장하는 예제 */
		
		// 1. Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		// 2. 리스트를 생성
		List<String> list = new ArrayList<String>();
		
		// 3. 반복문을 이용해서 문자열을 입력받아 리스트에 저장
		// 3-1. 5번 반복
		int count = 5;
		for(int i = 0; i < count; i++) {
			// 3-2. 콘솔에서 문자열을 입력받아 문자열 변수에 저장
			System.out.print("문자열 입력 : ");
			// 3-3. 문자열 변수를 리스트에 추가
			list.add(sc.nextLine()); // 문자열 변수에 저장 + 리스트에 추가
		}
		
		// 4. 저장된 문자열을 출력
		System.out.println(list);
		
		/* 문자열 A를 입력받아 리스트에 A를 포함하는 문자열들을 출력하는 예제 */
		
		// 1. 문자열 A를 입력 받아 변수에 저장
		System.out.print("검색할 문자열 입력 : ");
		String str = sc.nextLine();
		
		// 2. 반복문을 이용하여 전체 탐색 : 향상된 for문
		for (String tmp : list) {
			// 2-1. 리스트에서 꺼낸 문자열에 문자열A가 포함되어 있으면
			if(tmp.contains(str)) {
				// 2-2. 문자열을 입력
				System.out.println(tmp);
			}
		}
		
	}

}
