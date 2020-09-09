package streams.intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

// enum : class랑 비슷한데 이건 열거형 타입. 정의한 데이터만 사용 가능
enum Gender {
	MALE, FEMALE;
}

public class Employee {
	String name;
	Gender gender;
	LocalDate dateOfBirth;
	double income;

	public Employee(String name, Gender gender, LocalDate dateOfBirth, double income) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	// 리턴타입이 true/false인 메소드
	public boolean isMale() {
		return this.gender == Gender.MALE;
	}

	public boolean isFemale() {
		return this.gender == Gender.FEMALE;
	}

	@Override
	public String toString() {
		String str = String.format("(%s, %s, %s, %.2f)", name, gender, dateOfBirth, income);
		return str;
	}

	public static List<Employee> employees() {
		Employee e1 = new Employee("Lee", Gender.FEMALE, LocalDate.of(1997, Month.MARCH, 1), 2343.0);
		Employee e2 = new Employee("Kim", Gender.MALE, LocalDate.of(1990, Month.JANUARY, 20), 3000.0);
		Employee e3 = new Employee("Park", Gender.FEMALE, LocalDate.of(1995, Month.MARCH, 9), 2000.0);
		Employee e4 = new Employee("Yoon", Gender.MALE, LocalDate.of(1997, Month.SEPTEMBER, 11), 5000.0);
		Employee e5 = new Employee("Choi", Gender.FEMALE, LocalDate.of(1991, Month.DECEMBER, 25), 1500.0);

		List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5);
		return employees;
	}
}
