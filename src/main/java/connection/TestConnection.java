package connection;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import ers.beans.Employees;
import ers.beans.Forms;
import ers.beans.Managers;
import ers.dao.EmployeeDao;
import ers.dao.FormsDao;
import ers.dao.ManagerDao;
import ers.daoimpl.EmployeeDaoImpl;
import ers.daoimpl.FormsDaoImpl;
import ers.daoimpl.ManagerDaoImpl;

public class TestConnection {
	private EmployeeDao eDao = new EmployeeDaoImpl();
	private ManagerDao mDao = new ManagerDaoImpl();
	private FormsDao fDao = new FormsDaoImpl();
	
	
	@Test
	public void getAllEmployeesShouldReturn1() {
		List<Employees> employees = eDao.getAllEmployees();
		assertEquals(employees.size(), employees.size());
	}
	
	
	@Test public void getAllManagersShouldReturn1() { 
		List<Managers> managers = mDao.getAllManagers(); 
		assertEquals(1, managers.size()); 
	}
	  
	@Test public void getAllformsShouldReturn1() { 
		List<Forms> forms = fDao.getAllForms(); 
		assertEquals(forms.size(), forms.size()); 
	}
	 
}
