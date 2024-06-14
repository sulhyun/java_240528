package day13;

import java.util.Calendar;

public class CalendarEx01 {
	
	/* 달력을 표현한 클래스
	 * new 연산자로 객체 생성 X.*/
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR); // 연도를 추출
		int month = cal.get(Calendar.MONTH); // 월을 추출. (0 ~ 11) 그래서 1을 더해줘야됌
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "-" + (month + 1) + "-" + day);
	
	}
}
