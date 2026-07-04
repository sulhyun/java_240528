package day05;

public class ArrayEx01 {

	public static void main(String[] args) {
		
		// 5명의 학생 성적을 저장하기 위한 변수를 선해보세요.
		// 지역변수는 자동으로 초기화 된다? (x)
		int score1, score2, score3, score4, score5;
		
		// 5명의 학생 성적을 저장할 수 있는 배열을 생성
		// 배열은 자동으로 자료형에 맞는 초기화가 된다? (o)
		// 배열은 참조형. 실제 값을 저장하는게 아니라 주소를 저장함
		int[] scores1 = new int[5]; // 자주 내가 쓸 것
		int scores2[] = new int[5];
		// 5개짜리 배열을 만들어서 1,2,3,4,5 순서대로 초기화
		int[] scores3 = new int[] {1,2,3,4,5}; // 자주 내가 쓸것
		// int[] scores3 = {1,2,3,4,5}; 이렇게도 사용 가능
		int scores4[] = new int[] {1,2,3,4,5};
		
		// * 잘못된 인덱스 입력하면 ArrayIndexOutOfBounds (예외) 발생
		
		System.out.println(scores1); // scores1의 주소
		// 배열 초기화 전
		System.out.println(scores1[0]);
		System.out.println(scores1[1]);
		System.out.println(scores1[2]);
		System.out.println(scores1[3]);
		System.out.println(scores1[4]);
		
		System.out.println("배열 초기화 전");
		
		scores1[0] = 1;
		scores1[1] = 2;
		scores1[2] = 3;
		scores1[3] = 4;
		scores1[4] = 5;
		
		// 배열 초기화 후
		System.out.println(scores1[0]);
		System.out.println(scores1[1]);
		System.out.println(scores1[2]);
		System.out.println(scores1[3]);
		System.out.println(scores1[4]);
		
		System.out.println("배열 초기화 후");
		
		/*
		반복 횟수 : i는 0부터 5보다 작을때까지 1씩 증가
		규칙성 : 
		 */
		for (int i = 0; i < scores2.length; i++) {
			scores2[i] = i + 1;
			System.out.println(scores2[i]);
		}
		
		System.out.println("반복문을 이용한 배열 초기화");
		
		//System.out.println(scores1[0]);
		//System.out.println(scores1[1]);
		//System.out.println(scores1[2]);
		//System.out.println(scores1[3]);
		//System.out.println(scores1[4]);
		
		for (int i = 0; i < scores1.length; i++) {
			System.out.println(scores1[i]);
		}
		
		System.out.println("반복문을 이용한 배열 출력");
	}

}
