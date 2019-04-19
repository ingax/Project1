package ers.serviceimpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.beans.Managers;
import ers.dao.ManagerDao;
import ers.daoimpl.ManagerDaoImpl;
import ers.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	private final ManagerDao mDao = new ManagerDaoImpl();
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public List<Managers> getAllManagers(HttpServletRequest request, HttpServletResponse response) {
		return mDao.getAllManagers();
	}

	@Override
	public Managers getManagerById(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = mapper.readValue(request.getInputStream(), String.class);
			return mDao.getManagerById(id);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public Managers createManager(HttpServletRequest request, HttpServletResponse response) {
		try {
			Managers manager = mapper.readValue(request.getInputStream(), Managers.class);
			return mDao.createManager(manager);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public Managers updateManager(HttpServletRequest request, HttpServletResponse response) {
		try {
			Managers manager = mapper.readValue(request.getInputStream(), Managers.class);
			return mDao.updateManager(manager);
		}catch(IOException e) {
			return null;
		}
	}

	@Override
	public long deleteManager(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

}
