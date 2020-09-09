package streams.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistinctExample {
	public static void main(String[] args) {
		String[] strAry = { "Hong", "Park", "Choi", "Hong" };
		Stream<String> sStream = Arrays.stream(strAry);
		System.out.println("-- Distinct --");
		// distinct() : 중복 제거 중간 처리 메소드
		sStream.distinct().forEach(System.out::println);
		System.out.println("-- Sort --");
		// sorted() : 정렬 중앙 처리 메소드
		sStream = Arrays.stream(strAry);
		sStream.sorted().forEach(System.out::println);

		Student[] students = { new Student("lee", 100), new Student("lee", 100), new Student("lee", 88), //
				new Student("kim", 80), new Student("park", 70) };

		// 같은 값을 넣어도 다 뜬다 -> 값은 같지만 주소값이 다르기 때문
		// 이건 hashCode(), equals()를 적절히 사용해야 한다.
		Stream<Student> tStream = Arrays.stream(students);
//		tStream.distinct().forEach(System.out::println);

		// sorted() : 우선 순위 부여. Student에 implements Comparable 구현해줘야한다.
//		tStream.sorted().forEach(System.out::println);

		// 만약 Comparable이 구현이 안된 메소드이면 익명 구현 객체를 생성
		tStream.sorted(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return 0;
			}
		}).forEach(System.out::println);
	}
}
