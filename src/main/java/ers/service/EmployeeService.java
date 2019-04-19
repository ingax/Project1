package ers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.beans.Employees;

public interface EmployeeService {
	List<Employees> getAllEmployees(HttpServletRequest request, HttpServletResponse response);
	Employees getEmployeeById(HttpServletRequest request, HttpServletResponse response);
	Employees createEmployee(HttpServletRequest request, HttpServletResponse response);
	Employees updateEmployee(HttpServletRequest request, HttpServletResponse response);
	long deleteEmployee(HttpServletRequest request, HttpServletResponse response);
}
