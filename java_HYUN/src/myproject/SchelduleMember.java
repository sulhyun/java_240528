package myproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class SchelduleMember implements Serializable {

	private static final long serialVersionUID = 8227195181642815308L;
	
	private String id;		// 아이디
	private String name;	// 이름
	private List<Schedule> list = new ArrayList<Schedule>();
	
	public SchelduleMember(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchelduleMember other = (SchelduleMember) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
