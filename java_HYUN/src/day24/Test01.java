package day24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test01 {
	
	public static void main(String[] args) {
		String filName = "src/day24/test.txt";
		
		Food t = new Food();
		
		t.fileSave(filName);
	}

}

class Food implements Serializable{
	
	private static final long serialVersionUID = 8355968977637482181L;
	
	private String name;
	private int kcal;
	
	public Food() {}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	
	@Override
	public String toString() {
		return name + " : " + kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	public void fileSave(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			Food f = new Food("사과" , 20);
			oos.writeObject(f);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
