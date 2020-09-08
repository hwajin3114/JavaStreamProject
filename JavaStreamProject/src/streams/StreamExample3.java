package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConClass implements Consumer<Student> {
	@Override
	public void accept(Student t) {
		int cnt = 0, sum = 0;
		sum += t.score;
		cnt++;
	}
}

public class StreamExample3 {
	static int cnt = 0, sum = 0;

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("이땡땡", 90), new Student("윤땡땡", 88), new Student("김땡땡", 80),
				new Student("박땡땡", 86));
		// forEach(); 총 점수, 평균 가지고 오는 기능 구현
		ConClass con = new ConClass();
		list.stream().forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				sum += t.score;
				cnt++;
			}
		});
		System.out.println("총점 : " + sum + " | 평균 : " + (sum / (double) cnt));
	}
}
