package day16.homework;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class Ex01 {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new Student(1, 1, 2, "고길동", 100, 20, 30));
		list.add(new Student(1, 2, 1, "둘리", 60, 60, 70));
		
		/* 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		
		for (Student student : list) {
			sumKor += student.getKor();
			sumEng += student.getEng();
			sumMath += student.getMath();
		}
		
		double evgKor = sumKor / 3.0;
		double evgEng = sumEng / 3.0;
		double evgMath = sumMath / 3.0;
		
		System.out.println("국어 성적 평균 : " + evgKor);
		System.out.println("영어 성적 평균 : " + evgEng);
		System.out.println("수학 성적 평균 : " + evgMath);
		System.out.println();
		
		/* 각 학생의 국어, 영어, 수학 성적을 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
		for (Student student : list) {
			System.out.println("학생 이름: " + student.getName());
			System.out.println("국어 성적: " + student.getKor());
			System.out.println("영어 성적: " + student.getEng());
			System.out.println("수학 성적: " + student.getMath());
			System.out.println();
		}
		
		
	}

}

@Data
@AllArgsConstructor
class Student {
	
	@NonNull
	private int grade, classNum, num;
	
	@NonNull
	private String name;
	private int kor, eng, math;
		
}
