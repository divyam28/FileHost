package com.FileHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public List<MultipartFile> showFiles(Account account) {
		List<MultipartFile> fileList = account.getFiles();
		return fileList;
	}

	@Override
	public void addFile(List<MultipartFile> fileList, MultipartFile file) {
		fileList.add(file);
		
	}

	@Override
	public void deleteFile(List<MultipartFile> fileList, MultipartFile file) {
		fileList.remove(file);
		
	}

	@Override
	public void deleteUser(Account account) {
		accountrepository.delete(account);
		
	}
	
	
	

}
