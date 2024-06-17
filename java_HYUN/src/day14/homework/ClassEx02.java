package day14.homework;

public class ClassEx02 {
	
	/* 변수 : 하나의 데이터를 저정하는 공간
	 * 배열 : 같은 종류의 여러 데이터를 저장하는 공간
	 * 구조체 : 다른 종류의 여러 데이터를 저장하는 공간
	 * 클래스 : 데이터와 함수의 결합 (구조체 + 함수) */
	
	public static void main(String[] args) {
		
		Time t1 = new Time(6,34,30);
		
		System.out.println("현재시간 : " + t1.getHour() + "시 " + t1.getMinutes() + "분 " + t1.getSecond() + "초");
	}

}

class Time {
	// 멤버변수
	private int hour;
	private int minutes;
	private int second;
	
	// 생성자
	public Time(int hour, int minutes, int second) {
		super();
		this.hour = hour;
		this.minutes = minutes;
		this.second = second;
	}
	
	 
	// getter & setter
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 24) {
			return;
		}
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if (minutes < 0 || minutes > 59) {
			return;
		}
		this.minutes = minutes;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second < 0 || second > 59) {
			return;
		}
		this.second = second;
	}
	
}
