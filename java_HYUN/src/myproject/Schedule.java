package myproject;

import java.util.Date;

import lombok.Data;

@Data
public class Schedule {

	private Date date = new Date();		// 날짜
	private String schedule;			// 일정
	private String note;				// 상태
	
}
