package streams;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FromArrayExample {
	public static void main(String[] args) {
		int[] intAry = { 3, 6, 4, 9, 7 };
		IntStream iStream = Arrays.stream(intAry);
		// IntPredicate : 불린 리턴값
		iStream.filter(value -> value > 5) // IntPredicate를 람다식으로
				.forEach(value -> System.out.println(value)); // IntConsumer를 람다식으로
		// 최종 처리 메소드 forEach는 리턴값이 없다.

		iStream = Arrays.stream(intAry); // 이렇게 다시 반복자를 선언해줘야한다.
		long cnt = iStream.sum(); // 이것만 하면 더이상 처리할 반복자가 없어서
		System.out.println("cnt : " + cnt);

		// 0 ~ 3까지 가져오고 4는 제외
		iStream = Arrays.stream(intAry, 0, 4); // 위치 지정 가능
		// peek : 중간처리 메소드. 해당되는 요소 확인시에 사용
		cnt = iStream.peek(t->System.out.println(t)).count();
		System.out.println("cnt : " + cnt);
	}
}
