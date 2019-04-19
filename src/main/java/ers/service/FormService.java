package ers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.beans.Forms;

public interface FormService {
	List<Forms> getAllForms(HttpServletRequest request, HttpServletResponse response);
	Forms getFormById(HttpServletRequest request, HttpServletResponse response);
	Forms createForm(HttpServletRequest request, HttpServletResponse response);
	Forms updateForm(HttpServletRequest request, HttpServletResponse response);
	long deleteForm(HttpServletRequest request, HttpServletResponse response);
}
