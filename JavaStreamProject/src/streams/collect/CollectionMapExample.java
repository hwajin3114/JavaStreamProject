package streams.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapExample {
	public static void main(String[] args) {
		Student s1 = new Student("이땡땡", 24, Gender.FEMALE);
		Student s2 = new Student("윤땡땡", 26, Gender.MALE);
		Student s3 = new Student("김땡땡", 18, Gender.FEMALE);

		List<Student> students = Arrays.asList(s1, s2, s3);

		// toConcurrentMap : toMap이랑 같은데 병렬처리 되는거
		// Function<1, 2> 인터페이스 : 1번째 제네릭 타입을 받아서 2번째 제네릭 타입으로 반환하겠다.라는 의미
		Map<String, Integer> map = students.stream().filter(f -> f.age > 20)//
				.collect(Collectors.toMap(new Function<Student, String>() {
					@Override
					public String apply(Student t) { // key
						return t.name;
					}
				}, new Function<Student, Integer>() {
					@Override
					public Integer apply(Student t) { // value
						return t.age;
					}
				}));

		Set<String> keys = map.keySet();
		for (String s : keys) {
			System.out.println("이름 : " + s + ", 나이 : " + map.get(s));
		}
	}
}
