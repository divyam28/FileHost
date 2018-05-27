package com.FileHost;

import java.util.List;

public interface AccountService {
	
	public Boolean login(String user, String pass);
	public List<Account> getAllUsers();
	public void addUser(Account account);
	public void deleteUser(Account account);
	
	
}
