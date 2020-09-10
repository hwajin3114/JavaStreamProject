package streams.intermediate;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;

public class StreamMapExample {
	public static void main(String[] args) {
		List<common.Employee> employees = EmpDAO.getEmpList();
		// salary가 10000 이상인 사원 출력
		LocalDate date = LocalDate.of(2020, 5, 1);
		date.format(DateTimeFormatter.ISO_DATE); // 데이트타입 -> 문자열
		LocalDate.parse("2010-05-05", DateTimeFormatter.ISO_DATE); // 문자열 -> 데이트

		for (Employee emp : employees) {
//			System.out.println(emp.toString());
		}

		// DB를 활용해 스트림 사용
//		employees.stream().filter(e -> e.getEmployeeId() > 50) //
//				.forEach(s -> System.out.println(s.getEmployeeId()));

		// 직원id가 가장 큰 직원 출력
		Optional<Employee> result = employees.stream()//
//				.peek(s -> System.out.println(s.getEmployeeId()))//
				.reduce((t, u) -> t.getEmployeeId() > u.getEmployeeId() ? t : u);
		System.out.println(result);

		System.out.println();
		// 1995년 이후 입사한 직원
		employees.stream()
//				.sorted((t, u) -> t.getEmployeeId() > u.getEmployeeId() ? t.getEmployeeId() : u.getEmployeeId())
				.flatMap(t -> Stream.of(t.getHireDate())).filter(e -> e.isAfter(LocalDate.of(1995, 12, 31)))
				.forEach(System.out::println);

		System.out.println();
		employees.stream().filter(f -> f.getHireDate().isAfter(LocalDate.of(1995, 12, 31))) //
				.peek(p -> System.out.println(p.getEmployeeId() + " : " + p.getHireDate())) //
				.map(t -> t.getEmployeeId()).sorted().forEach(s->System.out.println());
	}
}
