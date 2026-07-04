package myproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class ScheduleMember implements Serializable {
	
	private static final long serialVersionUID = 8768950672316408437L;
	
	private String id;
	private String pw;
	private List<Schedule> list = new ArrayList<Schedule>();
	
	public ScheduleMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleMember other = (ScheduleMember) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return id + " : " + pw;
	}
}
