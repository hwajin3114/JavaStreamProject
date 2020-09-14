package common.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.Employee;

public class ExcelTestExample {
	public void excelWriter(List<Employee> list) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;

		// 사원번호, 이름, 메일주소, 급여, 입사일
		cell = row.createCell(0);
		cell.setCellValue("EmployeeID");

		cell = row.createCell(1);
		cell.setCellValue("FirstName");

		cell = row.createCell(2);
		cell.setCellValue("LastName");

		cell = row.createCell(3);
		cell.setCellValue("Email");

		cell = row.createCell(4);
		cell.setCellValue("Salary");

		cell = row.createCell(5);
		cell.setCellValue("HireDate");

		Employee emp;
		for (int i = 0; i < list.size(); i++) {
			emp = list.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell(0);
			cell.setCellValue(emp.getEmployeeId());

			cell = row.createCell(1);
			cell.setCellValue(emp.getFirstName());

			cell = row.createCell(2);
			cell.setCellValue(emp.getLastName());

			cell = row.createCell(3);
			cell.setCellValue(emp.getEmail());

			cell = row.createCell(4);
			cell.setCellValue(emp.getSalary());

			cell = row.createCell(5);
			cell.setCellValue(emp.getHireDate());
		}

		File file = new File("it_prog.xls");
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
					if (fos != null)
						fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
