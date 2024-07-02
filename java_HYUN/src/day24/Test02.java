package day24;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {
		
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("src/day24/test.txt", true);
			fw.write(99);
			fw.write(67);
			fw.flush();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if(fw != null) {
				fw.close();
			}
		} catch (IOException e) {
			System.out.println("파일을 닫을 수 없습니다.");
		}
	}

}
