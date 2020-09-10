package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	static Connection conn = ConnectDB.getDB();
	static PreparedStatement pstmt;
	static ResultSet rs;

	public static List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>();
		String sql = "select * from employees where salary >= 10000";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee employees = new Employee();
				employees.setEmployeeId(rs.getInt("employee_id"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setEmail(rs.getString("email"));
				employees.setHireDate(rs.getDate("hire_date").toLocalDate());
				employees.setJobId(rs.getString("job_id"));
				employees.setSalary(rs.getInt("salary"));
				list.add(employees);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
