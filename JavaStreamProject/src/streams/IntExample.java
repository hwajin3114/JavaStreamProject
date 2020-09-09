package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntExample {
	public static void main(String[] args) {
		// 1 ~ 10까지 정수형 배열
		// 배로부터 스트림을 생성하는 방법
		// 스트림을 생성하고 filter를 통해 짝수값을 가져와서 최종 집계 처리는 sum()으로
		int[] intAry = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		IntStream iStream = Arrays.stream(intAry);

		System.out.println("-- Range --");
		// 1~9. 10 포함 x
		IntStream.range(1, 10).forEach(s -> System.out.print(s + " "));
		System.out.println("\n-- Range Closed --");
		// 1~10. 10 포함
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		System.out.println("\n-- 5보다 작은 수 --");
		IntStream.rangeClosed(1, 10).filter(n -> n < 5).forEach(System.out::print);

		long sum = iStream.filter(value -> (value % 2 == 0)).sum();
		System.out.println("\n1 ~ 10 sum : " + sum);
	}
}
