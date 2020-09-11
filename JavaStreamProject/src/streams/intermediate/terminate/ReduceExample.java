package streams.intermediate.terminate;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;

public class ReduceExample {
	public static void main(String[] args) {
		// 사원의 평균 급여 계산
		List<Employee> empList = EmpDAO.getEmpList();
		// 전체 사원의 컬렉션을 통해 스트림 생성
		Stream<Employee> stream = empList.stream();

//		OptionalDouble avg = stream.mapToInt(t -> t.getSalary()).average();

		// Employee -> IntStream으로 매핑
//		OptionalDouble avg = stream.flatMapToInt(t -> IntStream.of(t.getSalary())).average();

		// Predicate : true/false를 반환하는 인터페이스
		OptionalDouble avg = stream.filter(t -> t.getJobId().equals("IT_PROG"))
				.flatMapToInt(t -> IntStream.of(t.getSalary())).average();

		System.out.println("평균 급여 : " + avg.getAsDouble());
	}
}
