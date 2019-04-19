package ers.service;

public interface LoginService {
	boolean checkEmployee(String username, String password);
	boolean checkManager(String username, String password);
}
