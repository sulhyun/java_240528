package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

public class Ex04 {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new Student(1, 1, 2, "고길동", 100, 20, 30));
		list.add(new Student(1, 2, 1, "둘리", 60, 60, 70));
		
		/* 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
        Supplier<Double> avgKorean = () -> list.stream()
                .mapToInt(Student::getKor)
                .average()
                .orElse(0.0);

        Supplier<Double> avgEnglish = () -> list.stream()
                .mapToInt(Student::getEng)
                .average()
                .orElse(0.0);

        Supplier<Double> avgMath = () -> list.stream()
                .mapToInt(Student::getMath)
                .average()
                .orElse(0.0);

        System.out.println("국어 평균 성적: " + avgKorean.get());
        System.out.println("영어 평균 성적: " + avgEnglish.get());
        System.out.println("수학 평균 성적: " + avgMath.get());
        System.out.println();
		
		/* 각 학생의 국어, 영어, 수학 성적을 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
		Consumer<Student> printGrades = student -> {
			System.out.println("학생 이름: " + student.getName());
			System.out.println("국어 성적: " + student.getKor());
			System.out.println("영어 성적: " + student.getEng());
			System.out.println("수학 성적: " + student.getMath());
			System.out.println();
		};
		
		list.forEach(printGrades);
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
