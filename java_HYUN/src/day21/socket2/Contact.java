package day21.socket2;

import java.util.Objects;
import java.util.regex.Pattern;

public class Contact {
	
	private String name;
	private String number;
	
	public Contact(String name, String number) throws Exception {
		this.name = name;
		setNumber(number);
	}
	
	@Override
	public String toString() {
		return name + " : " + number;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(number, other.number);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) throws Exception {
		/* 주어진 번호가 전화 번호 형태가 아니면 예외를 발생 시키고 맞으면 번호에 저장 
		 * 010-1234-5678 또는 02-123-4567 문자열 처리하기 위한 정규표현식 */
		String regex = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
		if (!Pattern.matches(regex, number)) {
			throw new Exception("주어진 번호는 전화 번호 형태가 아닙니다.");
		}
		this.number = number;
	}

}
