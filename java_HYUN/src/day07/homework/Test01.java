package day07.homework;

public class Test01 {

	public static void main(String[] args) {
		
		int num1 = 2;
		int num2 = 5;
		int result = 0;
		for (int i = num1; ; i += num1) {
			System.out.print(i + " ");	
			if(i == 100) {
				break;
			}
			System.out.println();
		}
		
	}

}
