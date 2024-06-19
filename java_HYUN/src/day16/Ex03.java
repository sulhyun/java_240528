package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


public class Ex03 {

	public static void main(String[] args) {
		
		List<StudentA> list = new ArrayList<StudentA>();
		
		list.add(new StudentA(1, 2, 1, "둘리", 60, 60, 70));
		list.add(new StudentA(1, 1, 1, "홍길동", 100, 20, 30));
		list.add(new StudentA(1, 1, 2, "고길동", 100, 20, 30));
		
		/* 국어 평균, 영어 평균, 수학 평균을 계산해서 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
		int sumKor = sumKor(list);
		System.out.println("국어 평균 : " + sumKor / (double)list.size());
		int sumEng = sumEng(list);
		System.out.println("영어 평균 : " + sumEng / (double)list.size());
		int sumMath = sumMath(list);
		System.out.println("수학 평균 : " + sumMath / (double)list.size());
		
		System.out.println();
		
		int sumKor2 = sum(list, s->s.getKor());
		System.out.println("국어 평균 : " + sumKor2 / (double)list.size());
		int sumEng2 = sum(list, s->s.getEng());
		System.out.println("영어 평균 : " + sumEng2 / (double)list.size());
		int sumMath2 = sum(list, s->s.getMath());
		System.out.println("수학 평균 : " + sumMath2 / (double)list.size());
		/* 각 학생의 국어, 영어, 수학 성적을 출력하는 코드를 작성하세요.
		 * 가능하면 함수형 인터페이스와 메소드를 이용해보세요. */
		
		printKor(list);
		printEng(list);
		printMath(list);
		
		System.out.println();
		
		print(list, s -> System.out.println("이름 : " + s.getName() + ", 국어 : " + s.getKor()));
		print(list, s -> System.out.println("이름 : " + s.getName() + ", 영어 : " + s.getEng()));
		print(list, s -> System.out.println("이름 : " + s.getName() + ", 수학 : " + s.getMath()));
		
		// 국어 성적이 80점 이상인 학생을 출력하는 코드를 작성하세요.
		
		printKor80(list);
		System.out.println();
		
		printStudent(list, (s) -> s.getKor() >= 80);
		System.out.println();
		
		// 1학년 1반 학생들을 출력하는 코드를 작성하세요.
		
		System.out.println("--1학년 1반 학생들--");
		printStudent11(list);
		System.out.println();
		
		printStudent(list, s -> s.getGrade() == 1 && s.getClassNum() == 1);
		System.out.println();
		
		// 1학년 1반 1번 학생을 출력하는 코드를 작성하세요.
		
		System.out.println("--1학년 1반 1번 학생--");
		printStudent111(list);
		System.out.println();
		
		printStudent(list, s -> s.getGrade() == 1 && s.getClassNum() == 1 && s.getNum() == 1);
		System.out.println();
		
		printStudent(list, s -> true);
		
		Collections.sort(list, (o1, o2) -> o2.getEng() - o1.getEng());
		printStudent(list, s -> true);
	}
	
	public static void printStudent(List<StudentA> list, Predicate<StudentA> p) {
		for (StudentA tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
	
	public static void printStudent111(List<StudentA> list) {
		for (StudentA tmp : list) {
			if (tmp.getGrade() == 1 && tmp.getClassNum() == 1 && tmp.getNum() == 1) {
				System.out.println(tmp.getName());
			}
		}
	}
	
	public static void printStudent11(List<StudentA> list) {
	
		for (StudentA tmp : list) {
			if (tmp.getGrade() == 1 && tmp.getClassNum() == 1) {
				System.out.println(tmp.getName());
			}
		}
		
	}
	
	public static void printKor80(List<StudentA> list) {
		System.out.println("--국어 80점 이상 학생--");
		for(StudentA tmp : list) {
			if(tmp.getKor() >= 80) {
				System.out.println(tmp.getName());
			}
		}
	}
	
	public static void print(List<StudentA> list, Consumer<StudentA> c) {
		for(StudentA tmp : list) {
			c.accept(tmp);
		}
	}
	
	public static void printKor(List<StudentA> list) {
		for(StudentA tmp : list) {
			System.out.println("이름 : " + tmp.getName() + ", 국어 : " + tmp.getKor());
		}
	}
	
	public static void printEng(List<StudentA> list) {
		for(StudentA tmp : list) {
			System.out.println("이름 : " + tmp.getName() + ", 영어 : " + tmp.getKor());
		}
	}
	
	public static void printMath(List<StudentA> list) {
		for(StudentA tmp : list) {
			System.out.println("이름 : " + tmp.getName() + ", 수학 : " + tmp.getKor());
		}
	}

	public static int sum(List<StudentA> list, Function<StudentA, Integer> f) {
		int sum = 0;
		for(StudentA tmp : list) {
			sum += f.apply(tmp);
		}
		return sum;
	}
	
	public static int sumKor(List<StudentA> list) {
		int sum = 0;
		for(StudentA tmp : list) {
			sum += tmp.getKor();
		}
		return sum;
	}
	
	public static int sumEng(List<StudentA> list) {
		int sum = 0;
		for(StudentA tmp : list) {
			sum += tmp.getEng();
		}
		return sum;
	}
	
	public static int sumMath(List<StudentA> list) {
		int sum = 0;
		for(StudentA tmp : list) {
			sum += tmp.getMath();
		}
		return sum;
	}

}

@Data
@AllArgsConstructor
class StudentA {
	
	@NonNull
	private int grade, classNum, num;
	
	@NonNull
	private String name;
	private int kor, eng, math;
	
	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " + name;
	}
	
	
}
