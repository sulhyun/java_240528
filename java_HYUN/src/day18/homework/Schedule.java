package day18.homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule {
	
	String date; // 날짜 정보
	String schedule; // 일정
	String note; // 비고
	
	@Override
	public String toString() {
		return date + " " + schedule + " " + note;
	}
	
	
}
