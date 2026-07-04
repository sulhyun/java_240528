package day09.access;

public class Student {
	
	/* private : 자신 클래스
	 * (default) : 자신 클래스 + 같은 패키지
	 * protected : 자신 클래스 + 같은 패키지 + 자식 클래스
	 * public : 모두
	 * */
	
	/* 일반적으로 멤버변수들은 private
	 * getter/setter 를 이용하여 접근
	 * 일반적으로 메서드는 public
	 * 일반적으로 생성자는 public. 단, 싱글톤을 만들때는 private 으로
	 * 클래스에 public 이 붙으려면, 클래스 이름과 파일명이 같아야함
	 * */

	public int grade;
	protected int classNum;
	int num; // default
	private String name;
}
