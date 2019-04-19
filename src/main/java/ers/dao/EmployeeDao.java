package ers.dao;

import java.util.List;

import ers.beans.Employees;

public interface EmployeeDao {
	List<Employees> getAllEmployees();
	Employees getEmployeeById(String employee_id);
	Employees createEmployee(Employees e);
	Employees updateEmployee(Employees updateEmp);
	long deleteEmployee(Employees... deleteEmp);
}
