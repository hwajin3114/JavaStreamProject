package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseGroupby {
	public static void main(String[] args) {
		// 직무별 - 사원 그룹

		List<Employee> emps = EmpDAO.getEmpList();

		Map<String, Set<Employee>> eMap = emps.stream()//
				.collect(Collectors.groupingBy(new Function<Employee, String>() {
					@Override
					public String apply(Employee t) {
						return t.getJobId();
					}
				}, Collectors.toSet()));

		Set<String> set = eMap.keySet();
		for (String s : set) {
			System.out.println("--- " + s + " ---");
			Set<Employee> list = eMap.get(s);
			for (Employee e : list) {
				System.out.println(e.getLastName());
			}
		}
	}
}
