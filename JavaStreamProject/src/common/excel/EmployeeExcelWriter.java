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

public class EmployeeExcelWriter {
// 여러 cell들을 한 row라 하고 그게 모여서 sheet 그리고 sheet가 모여서 .xls 파일
	public void xlsWriter(List<Employee> list) { // 매개값으로 데이터부분이 들어온다(Employee)
		HSSFWorkbook workbook = new HSSFWorkbook(); // excel 파일 생성
		HSSFSheet sheet = workbook.createSheet(); // excel 시트 생성
		HSSFRow row = sheet.createRow(0); // row 생성
		HSSFCell cell;

		// 여기는 타이틀이 들어온다?
		cell = row.createCell(0); // 첫번째 cell
		cell.setCellValue("EmployeeID");

		cell = row.createCell(1);
		cell.setCellValue("FirstName");

		cell = row.createCell(2);
		cell.setCellValue("LastName");

		cell = row.createCell(3);
		cell.setCellValue("Email");

		cell = row.createCell(4);
		cell.setCellValue("Salary");

		Employee emp; // 이제 루핑 돌면서 데이터를 가져올거다.
		for (int i = 0; i < list.size(); i++) {
			emp = list.get(i);

			// (i+1)하면 row 값이 순차적으로 들어간다. 신규 line
			row = sheet.createRow(i+1);

			cell = row.createCell(0); // 첫번째 cell
			cell.setCellValue(emp.getEmployeeId()); // 실제 값 가져오기

			cell = row.createCell(1);
			cell.setCellValue(emp.getFirstName());

			cell = row.createCell(2);
			cell.setCellValue(emp.getLastName());

			cell = row.createCell(3);
			cell.setCellValue(emp.getEmail());

			cell = row.createCell(4);
			cell.setCellValue(emp.getSalary());
		}

		// File I/O
		File file = new File("employeeExcel.xls");
		FileOutputStream fos = null;	// file을 읽기 용도로 불러오고싶다.

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);	// file에 값을 계속 쓸거다.
		} catch (FileNotFoundException e) { // File 읽고쓰기 예외 처리
			e.printStackTrace();
		} catch (IOException e) { // IO 예외 처리
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close(); // 얘도 파일 예외 처리
					if (fos != null)
						fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
