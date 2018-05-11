package com.FileHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
	
	@Autowired
	private AccountRepository accountrepository;

	@Override
	public Boolean login(Account account) {
		return accountrepository.existsById(account.getId());
	}

	@Override
	public List<Account> getAllUsers() {
		return accountrepository.findAll();
	}

	@Override
	public void addUser(Account account) {
		accountrepository.save(account);
		
	}
	

}
