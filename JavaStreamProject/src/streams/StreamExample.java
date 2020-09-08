package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// 이전에 컬렉션을 통해 한것은 외부 반복자
		// Arrays : 배열처리에 적절한 메소드 다수 보유
		List<String> users = Arrays.asList("홍길동", "이땡땡", "윤땡땡", "김땡땡");
		System.out.println("-- 외부 반복자 Iterator --");
		Iterator<String> iter = users.iterator(); // Iterator : 반복자
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str.toString());
		}

		// 스트림 -> 내부 반복자. 람다표현식 가능
		Stream<String> streams = users.stream(); // Stream : 반복자
		// 우리가 반복된 요소를 가져오는건 할 필요없다. 요소 처리만 해주면 됨
		// 외부 반복자는 요소를 가져와서 hasNext로 있나 확인하고 출력해야 했지만 얘는 Stream이 다해줌
		// Consumer : 매개값은 받지만 리턴값은 없다. 함수적 메소드
		System.out.println("-- 내부 반복자 Stream --");
//		streams.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String t) {
//				System.out.println(t.toString());
//			}
//		});
		
		// 스트림을 람다 표현식으로 간소화
		// forEach : 반복된 요소 처리
		// stream 뒤에 오는 메소드는 stream 안에 들어있는 요소 하나하나를 반복적으로 처리하는 것
		streams.forEach((t) -> System.out.println(t.toString()));
	}
}