package day18;

public class ThreadEx02 {

	public static void main(String[] args) {
		
		// Runnable 인터페이스를 이용한 쓰레드 생성 예제
		
		// 방법1
		MyThread2 mt = new MyThread2();
		//Thread tread = new Thread(mt);
		
		// 방법2
		Runnable r = () -> {
			for(int i = 0; i < 10000; i++) {
				System.out.print("-");
			}
		};
		Thread tread = new Thread(r);
		
		tread.start();

		for(int i = 0; i < 10000; i++) {
			System.out.print("|");
		}
	}
	
}

class MyThread2 implements Runnable {
	
	
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.print("-");
		}
	}
}