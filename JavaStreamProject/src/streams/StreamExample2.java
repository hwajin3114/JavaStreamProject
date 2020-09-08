package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Student {
	String name;
	int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}

public class StreamExample2 {
	public static void main(String[] args) {
		// 이땡땡, 90 / 윤땡땡, 88 / 김땡땡, 83 / 박땡땡 86
		// score >= 85이 몇명인지 rCnt 변수에 담고 해당하는 사람 출력
		List<Student> list = Arrays.asList(new Student("이땡땡", 90), new Student("윤땡땡", 88), new Student("김땡땡", 80),
				new Student("박땡땡", 86));
		// stream 메소드로 list의 요소가 students에 하나씩 추가된다.
		Stream<Student> students = list.stream();
		// Predicate 인터페이스 : 매개값도 받고 리턴은 불린 타입
		// filter, peek : stream()의 중간 처리 메소드. 최종 처리 메소드가 없으면 사용 불가
		// count : 최종 처리 메소드
		long iCnt = students.filter(t -> t.score >= 85) // Predicate
				.peek(t -> System.out.println(t.name + ", " + t.score)) // Consumer
				.count();
		System.out.println("총 인원 : " + iCnt);

		// forEach : 최종 처리 메소드
		/*
		students.filter(t -> t.score >= 85) // Predicate
				.peek(t -> System.out.println(t.name + ", " + t.score)) // Consumer
				.filter(t -> t.name.startsWith("이")) // Predicate
				.forEach(new Consumer<Student>() {
					@Override
					public void accept(Student t) {
						System.out.println(t.name + ", " + t.score);
					}
				});
		*/
	}
}
