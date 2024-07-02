package day17;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point implements Serializable{
	
	private static final long serialVersionUID = 941182918428437876L;
	
	private int x,y;
	
	transient int i;
	
}
