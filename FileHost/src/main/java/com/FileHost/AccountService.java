package com.FileHost;

import java.util.List;

public interface AccountService {
	
	public Boolean login(Account account);
	public List<Account> getAllUsers();
	public void addUser(Account account);
	
}
