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

		long sum = iStream.filter(value -> (value % 2 == 0)).sum();
		System.out.println("sum : " + sum);
	}
}
