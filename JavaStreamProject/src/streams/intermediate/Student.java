package streams.intermediate;

import java.util.Objects;

// Comparable 인터페이스 구현 객체
public class Student implements Comparable<Student> {
	String name;
	int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	@Override
	public int hashCode() {
//		return this.score;	// 1. 점수가 같으면 중복
//		return this.name.hashCode(); // 2. 이름 같으면 중복
//		return Objects.hashCode(this.name);	// 2. 이것도 이름 같으면 중복
		return Objects.hashCode(this.name) + this.score; // 3. 이름, 점수 같으면 중복
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student that = (Student) obj;
//			return this.score == that.score;	// 1. 점수가 같으면 중복
//			return this.name.equals(that.name); // 2. 이름 같으면 중복
			return this.name.equals(that.name) && this.score == that.score; // 3. 이름, 점수 같으면 중복
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.score - o.score;	// 음수 : 오름차순. 양수 : 내림차순
	}
}
