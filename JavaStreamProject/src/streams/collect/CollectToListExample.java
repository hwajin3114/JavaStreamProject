package streams.collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum Gender { // 열거형. Gender 타입의 필드
	MALE, FEMALE;
}

class Student {
	String name;
	int age;
	Gender gender;

	public Student(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}

public class CollectToListExample {
	public static void main(String[] args) {
		Student s1 = new Student("이땡땡", 24, Gender.FEMALE);
		Student s2 = new Student("윤땡땡", 26, Gender.MALE);
		Student s3 = new Student("김땡땡", 28, Gender.FEMALE);

		List<Student> students = Arrays.asList(s1, s2, s3);

		System.out.println("---- List ----");
		// Collector : 저장타입요소, 저장방식(A), 이형태로반환?하겠다?(B) 뭐.. 아무튼 인터페이스
		// Collectors 클래스가 가진 toList 메소드 이용. 이걸 구현할 뭐 그런거를 collector에 담겠다. collector 구현
		Collector<? super Student, ?, List<Student>> collector = Collectors.toList();
		// stream 값을 collection에 담을거다
		List<Student> newList = students.stream()//
				.filter(t -> t.gender == Gender.MALE)//
				.collect(collector); // collect : collector에 지정한 방식대로 collection을 만들겠다.

		// 새로운 collection : newList
		newList.stream().forEach(s -> System.out.println(s.name + ", " + s.age));
		System.out.println("---- Set ----");

		// 나이가 25살 넘는 사람들. set에 담기
		// Collectoer 선언안해주고 바로 Collectors.toSet() 해도 된다.
		Set<Student> setList = students.stream()//
				.filter(s -> s.age > 25)//
				.collect(Collectors.toSet());
		
		Iterator<Student> iter = setList.iterator();
		while (iter.hasNext()) {
			Student stu = iter.next();
			System.out.println(stu.name + ", " + stu.age);
		}
	}
}
