package ers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.beans.Managers;

public interface ManagerService {
	List<Managers> getAllManagers(HttpServletRequest request, HttpServletResponse response);
	Managers getManagerById(HttpServletRequest request, HttpServletResponse response);
	Managers createManager(HttpServletRequest request, HttpServletResponse response);
	Managers updateManager(HttpServletRequest request, HttpServletResponse response);
	long deleteManager(HttpServletRequest request, HttpServletResponse response);
}
