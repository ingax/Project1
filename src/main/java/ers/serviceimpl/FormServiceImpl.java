package ers.serviceimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.beans.Forms;
import ers.dao.FormsDao;
import ers.daoimpl.FormsDaoImpl;
import ers.service.FormService;

public class FormServiceImpl implements FormService	{

	private final FormsDao fDao = new FormsDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();
	@Override
	public List<Forms> getAllForms(HttpServletRequest request, HttpServletResponse response) {
		return fDao.getAllForms();
	}

	@Override
	public Forms getFormById(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = mapper.readValue(request.getInputStream(), int.class);
			return fDao.getFormById(id);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public Forms createForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			Forms form = mapper.readValue(request.getInputStream(), Forms.class);
			return fDao.createForm(form);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public Forms updateForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			Forms form = mapper.readValue(request.getInputStream(), Forms.class);
			return fDao.updateForm(form);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public long deleteForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

}
