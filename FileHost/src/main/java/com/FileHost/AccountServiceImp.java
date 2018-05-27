package com.FileHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.ResponseCode;
import Exceptions.UtilityException;

@Service
public class AccountServiceImp implements AccountService {
	
	@Autowired
	private AccountRepository accountrepository;

	@Override
	public Boolean login(String user,String pass) {
		Account acc = accountrepository.findByUsername(user);
		if(acc != null) {
			if(pass == acc.getPassword()) {
				return true;
			}
			else {
				throw new UtilityException(ResponseCode.INVALID_PASSWORD);
			}
		}
		else {
			throw new UtilityException(ResponseCode.USER_NEEDS_SIGNUP);
		}
	}

	@Override
	public List<Account> getAllUsers() {
		return accountrepository.findAll();
	}

	@Override
	public void addUser(Account account) {
		accountrepository.save(account);
		
	}

	@Override
	public void deleteUser(Account account) {
		accountrepository.delete(account);
		
	}

	
	
	

}
