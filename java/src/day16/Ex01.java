package day16;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		/* Up Down 게임 예제를 구현하세요 
		 * 랜덤으로 숫자를 만들고(1~100) 만들어진 숫자를 맞추는 게임 */
		
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 100;
		int random = random(min, max);
		int user;
		System.out.println("랜덤 : " + random);
		System.out.println("GAME START!!!");
		do {
			System.out.print("입력 : ");
			user = sc.nextInt();
			printResult(random, user);
		}while(user != random);
	}
	
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	public static void printResult(int random, int user) {
		if (1 > user || 100 < user) {
			System.out.println("범위를 벗어났습니다.");
		}
		else if (random > user) {
			System.out.println("UP");
		}
		else if (random < user) {
			System.out.println("DOWN!");
		}
		else {
			System.out.println("정답!!!");
		}
	}

}
