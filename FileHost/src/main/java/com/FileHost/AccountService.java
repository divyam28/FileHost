package com.FileHost;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AccountService {
	
	public Boolean login(Account account);
	public List<Account> getAllUsers();
	public void addUser(Account account);
	public List<MultipartFile> showFiles(Account account);
	public void addFile(List<MultipartFile> fileList, MultipartFile file);
	public void deleteFile(List<MultipartFile> fileList, MultipartFile file);
	
	
}
