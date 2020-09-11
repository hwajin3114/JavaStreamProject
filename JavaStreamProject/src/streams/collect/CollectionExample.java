package streams.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import streams.intermediate.Student;

public class CollectionExample {
	public static void main(String[] args) {
//		---------------------------------------------------
		System.out.println("[ Set Collection ]");
		Set<String> setStr = new HashSet<>();
		setStr.add(new String("이땡땡"));
		setStr.add(new String("윤땡땡"));
		setStr.add(new String("김땡땡"));

		for (String s : setStr) {
//			System.out.println(s);
		}

		Iterator<String> iter = setStr.iterator(); // 반복자
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
//		---------------------------------------------------
		System.out.println("[ List Collection ]");
		List<Student> students = new ArrayList<>();
		students.add(new Student("이땡땡", 100));
		students.add(new Student("윤땡땡", 50));

		List<Student> students2 = new ArrayList<>();
		students2.add(new Student("김땡땡", 30));
		students2.add(new Student("박땡땡", 70));

		List<Student> students3 = new ArrayList<>();
		students3.add(new Student("최땡땡", 90));
		students3.add(new Student("석땡땡", 20));

		for (Student stu : students) {
			System.out.println(stu);
		}
//		---------------------------------------------------
		System.out.println("[ Map Collection ]");
		Map<String, Integer> map = new HashMap<>();
		map.put("이땡땡", 24);
		map.put("윤땡땡", 26);

		Set<String> key = map.keySet(); // key 가져오기 -> key를 기준으로 value 가져오기
		Iterator<String> iter2 = key.iterator();
		while (iter2.hasNext()) {
			String k = iter2.next();
			System.out.println(map.get(k)); // map에 key 가져오면 value 출력
		}

		System.out.println("[ Map Collection - key가 Collection ]");
		Map<String, List<Student>> stMap = new HashMap<>();
		stMap.put("1학년", students);
		stMap.put("2학년", students2);
		stMap.put("3학년", students3);

		Set<String> setKey = stMap.keySet();
		Iterator<String> sit = setKey.iterator();
//		while(sit.hasNext()) {
//			String keys = sit.next();
//			for(Student st : stMap.get(keys)) {
//				System.out.println(st);
//			}
//		}
		
		for (String s : setKey) {
			System.out.println(s);
			List<Student> valueList = stMap.get(s); // key(s)에 해당하는 value 가져오기
			for (Student stu : valueList) {
				System.out.println(stu);
			}
		}
//		---------------------------------------------------
	}
}