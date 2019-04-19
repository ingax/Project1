package ers.serviceimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.beans.Employees;
import ers.dao.EmployeeDao;
import ers.daoimpl.EmployeeDaoImpl;
import ers.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeDao eDao = new EmployeeDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Employees> getAllEmployees(HttpServletRequest request, HttpServletResponse response) {
		return eDao.getAllEmployees();
	}

	@Override
	public Employees getEmployeeById(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = mapper.readValue(request.getInputStream(), String.class);
			return eDao.getEmployeeById(id);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public Employees createEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employees employee = mapper.readValue(request.getInputStream(), Employees.class);
			return eDao.createEmployee(employee);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public Employees updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employees employee = mapper.readValue(request.getInputStream(), Employees.class);
			return eDao.updateEmployee(employee);
		}catch(IOException e) {
			return null;
		}
	}
		

	@Override
	public long deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

}
