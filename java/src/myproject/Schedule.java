package myproject;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Schedule implements Serializable, Comparable<Schedule>{

	private static final long serialVersionUID = -5454249333392608158L;
	
	private String schedule;			// 일정
	private String note;				// 상태
	private Date date = new Date();		// 날짜
	
	public Schedule(String schedule, String note, String date) throws ParseException {
		this.schedule = schedule;
		this.note = note;
		setDate(date);
	}
	
	@Override
	public String toString() {
		return getDate() + " " + schedule + " " + note;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(date, other.date);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
	
	@Override
	public int compareTo(Schedule o) {
		return date.compareTo(o.date);
	}	
	
	public void setDate(String date) throws ParseException {
		SimpleDateFormat format = 
				new SimpleDateFormat("yyyy-MM-dd hh:mm");
		this.date = format.parse(date);
	}
	
	public String getDate() {
		SimpleDateFormat format =
				new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.format(date);
	}

	
	public void updateSchedule(String schedule, String note, String date) throws ParseException {
		this.schedule = schedule;
		this.note = note;
		setDate(date);
	}
}
