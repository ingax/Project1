package ers.dao;

import java.util.List;

import ers.beans.Managers;

public interface ManagerDao {
	List<Managers> getAllManagers();
	Managers getManagerById(String manager_id);
	Managers createManager(Managers m);
	Managers updateManager(Managers updateMngr);
	long deleteManager(Managers... deleteMngr);
}
