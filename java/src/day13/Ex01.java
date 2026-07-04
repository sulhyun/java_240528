package day13;

import java.util.Scanner;

public class Ex01 {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		/* 다음과 같은 책 제목들이 있을 때 원하는 단어를 검색해서 해당 단어가 있는
		 * 책을 출력하는 코드를 작성하세요. 
		 * 일치하는 책이 없는 경우 일치하는 책이 없습니다라고 출력 */
		
		String[] books = {"자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C"};
		isBook(books);
	}
	
	public static void isBook(String[] books) {
		if (books == null || books.length == 0) {
			return;
		}
		
		System.out.print("책을 입력 : ");
		String book = scan.nextLine();
		int count = 0;
		
		for(int i = 0; i < books.length; i++) {
			if(books[i].indexOf(book) >= 0) {
				System.out.println(books[i]);
				count++;
			}
		}
		
		if(count == 0) {
			System.out.println("일치하는 책이 없습니다.");
		}
	}
}
