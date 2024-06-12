package day11;

public class CopyEx01 {

	public static void main(String[] args) {
		
		// 얕은 복사 예제
		C [] listA = new C [5];
		C [] listB = new C [5];
		
		for(int i = 0; i < listA.length; i++) {
			listA[i] = new C (2 * i);
		}
		System.arraycopy(listA, 0, listB, 0, listA.length);
		
		System.out.println("얕은 복사 (값 변경 전)");
		print(listA);
		print(listB);
		
		System.out.println("얕은 복사 (값 변경 후)");
		listA[0].num = 100;
		
		print(listA);
		print(listB);
		
		// 깊은 복사 예제
		C [] listC = new C [5];
		C [] listD = new C [5];
		
		for(int i = 0; i < listC.length; i++) {
			listC[i] = new C (2 * i);
		}
		
		for(int i = 0; i < listC.length; i++) {
			listD[i] = new C(listC[i]);
		}
		
		System.out.println("깊은 복사 (값 변경 전)");
		print(listC);
		print(listD);
		
		System.out.println("깊은 복사 (값 변경 후)");
		listC[0].num = 100;
		
		print(listC);
		print(listD);
		
	}
	
	public static void print(C [] list) {
		for(C tmp : list) {
			tmp.print();
		}
		System.out.println();
	}

}

class C {
	public int num;
	
	// 생성자
	public C (int num) {
		this.num = num;
	}
	
	// 복사 생성자
	public C (C c) {
		this.num = c.num;
	}
	
	public void print() {
		System.out.print(num + " ");
	}
	
}
