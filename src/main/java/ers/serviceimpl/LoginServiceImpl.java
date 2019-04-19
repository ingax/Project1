package ers.serviceimpl;

import java.util.List;

import ers.beans.Employees;
import ers.beans.Managers;
import ers.dao.EmployeeDao;
import ers.dao.ManagerDao;
import ers.daoimpl.EmployeeDaoImpl;
import ers.daoimpl.ManagerDaoImpl;
import ers.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	private static final EmployeeDao eDao = new EmployeeDaoImpl();
	private static final ManagerDao mDao = new ManagerDaoImpl();
	
	public LoginServiceImpl() {}


	@Override
	public boolean checkEmployee(String username, String password) {
		List<Employees> employees = eDao.getAllEmployees();
		System.out.println("Employees + " + employees);
		boolean found = false;
		int i = 0;
		while(!found && (i < employees.size())) {
			if(username.equals(employees.get(i).getEmployee_Id())) {
				System.out.println("Found user");
				if(password.contentEquals(employees.get(i).getPassword())) {
					System.out.println("Found Password");
					found = true;
				}
				else
					break;
			} i++;
		} return found;
	}
	
	public boolean checkManager(String username, String password) {
		List<Managers> managers = mDao.getAllManagers();
		System.out.println("Managers  " + managers);
		boolean found = false;
		int i = 0;
		while(!found || (i < managers.size())) {
			if(username.equals(managers.get(i).getManager_id())) {
				System.out.println("Found user");
				if(password.contentEquals(managers.get(i).getPassword())) {
					System.out.println("Found Password");
					found = true;
				} 
				else
					break;
			} i++;
		} return found;
	}
}
