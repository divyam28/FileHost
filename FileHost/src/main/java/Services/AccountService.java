package Services;

import java.util.List;

import DTO.Account;

public interface AccountService {
	
	public Boolean login(String user, String pass);
	public List<Account> getAllUsers();
	public void addUser(Account account);
	public void deleteUser(Account account);
	
	
}
