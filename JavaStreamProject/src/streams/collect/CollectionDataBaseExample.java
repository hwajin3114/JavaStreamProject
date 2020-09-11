package streams.collect;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseExample {

	public static void main(String[] args) {

		List<Employee> employees = EmpDAO.getEmpList();

		// employees 테이블
		// 입사일 기준. 1990년대 입사한 사람들
		// List 컬렉션에 저장
		List<Employee> empList = employees.stream().//
				filter(f -> f.getHireDate().isBefore(LocalDate.of(2000, 1, 1))
						&& f.getHireDate().isAfter(LocalDate.of(1989, 12, 31)))
				.collect(Collectors.toList());
		
		for(Employee e : empList) {
			System.out.println(e.getHireDate());
		}
//		empList.stream().forEach(s -> System.out.println(s.getFirstName() + " : " + s.getHireDate()));

		// Job == ST_CLERK인 사람들의 이름과 급여를 컬렉션에 저장
		Map<String, Integer> map = employees.stream().filter(f -> f.getJobId().equals("ST_CLERK"))
				.collect(Collectors.toMap(new Function<Employee, String>() {
					@Override
					public String apply(Employee t) {
						return t.getFirstName();
					}
				}, new Function<Employee, Integer>() {
					@Override
					public Integer apply(Employee t) {
						return t.getSalary();
					}
				}));

		Set<String> key = map.keySet();

//		for (String s : key) {
//			System.out.println("이름 : " + s + ", 월급 : " + map.get(s));
//		}
	}
}
