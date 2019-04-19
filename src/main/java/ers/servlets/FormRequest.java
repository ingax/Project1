package ers.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.service.FormService;
import ers.serviceimpl.FormServiceImpl;

public class FormRequest {

	public static final FormService fService = new FormServiceImpl();
	
	private FormRequest() {};
	
	public static Object doGet(HttpServletRequest request, HttpServletResponse response) {
		return fService.getAllForms(request, response);
	}
	
	public static Object doPost(HttpServletRequest request, HttpServletResponse response) {
		return fService.createForm(request, response);
	}
}
