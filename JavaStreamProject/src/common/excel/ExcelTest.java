package common.excel;
import java.util.List;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class ExcelTest {
	public static void main(String[] args) {
		ExcelTestExample writer = new ExcelTestExample();
		List<Employee> list = EmpDAO.getEmpList();
		List<Employee> empList = list.stream().filter(t -> t.getJobId().equals("IT_PROG")).collect(Collectors.toList());

		writer.excelWriter(empList);
		System.out.println("엑셀 생성 완료");
	}
}
