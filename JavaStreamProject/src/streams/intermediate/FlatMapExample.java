package streams.intermediate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	// mapping. 매칭
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		// flatMap : int를 받아서 또다른 Stream 타입으로 반환
		// Function 인터페이스 : 앞의 타입을 받아 처리후에 뒤에 타입으로 반환
		stream.flatMap(t -> Stream.of(t * 3) // integer로 받아서 stream 값으로 반환
		).forEach(System.out::println);
		System.out.println();

		// flatMapToDouble : 입력받은 값을 Double 타입으로 반환
		// OptionalDouble : 선택적인 Double -> min, max. 에러발생안시키기위함
		// min은 이미 만들어둔 집계함수. 이걸 reduce로 구현 가능하다.
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(t -> DoubleStream.of(t.getIncome())

		// min()
//		).filter(n -> n > 4000).reduce((left, right) -> left > right ? left : right);

		// sum()
		).reduce((left, right) -> {
			System.out.println(left + ", " + right);
			return left + right;
		});

		if (result.isPresent()) // result가 true이면 result 출력해라
			System.out.println("result : " + result);
		else
			System.out.println("결과 없음");
		System.out.println();

		// String 값으로 반환하는 flatMap
		Employee.employees().stream().flatMap(t -> Stream.of(t.getName())).forEach(System.out::println);
		System.out.println();

		// 생일을 가져와서 reduce()를 이용해 min이나 max값 가져오기
		// reduce : accumulator 타입으로 반환. 연산 결과. 내가 원하는 방식으로 집계(커스터마이징)
		// 처음에는 t, u 값을 비교하고 그 다음에는 그 결과값(return되는 값)과 u를 비교.
		Optional<LocalDate> min = Employee.employees().stream().flatMap(t -> Stream.of(t.getDateOfBirth()))
				.reduce((t, u) -> {
					System.out.println(t + ", " + u);
					// t, u를 비교해서 작은 값을 return 해주면 반복해서 젤 작은 수가 마지막에 출력
					// t가 u보다 앞선 값이면 t 아니면 u 출력
					return t.isBefore(u) ? t : u;
				});

		System.out.println("min : " + min);
	}
}