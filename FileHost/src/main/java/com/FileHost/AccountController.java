package com.FileHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/{user}/{pass}")
	public String Login(@PathVariable String user,@PathVariable String pass) {
		if(accountService.login(user, pass)) {
			return("Login Success!");
		}
		else {
			return "Fail";
		}
	}
	
    @RequestMapping("/login")
	public String showLoginPage(){
        return "login.html";

    }
	
	@RequestMapping("/allusers")
	public List<Account> getAllUsers(){
		return accountService.getAllUsers();
	}
	
	@RequestMapping(value = "/adduser",method=RequestMethod.POST)
	public void addUser(@RequestBody Account account) {
		accountService.addUser(account);
	}
	
	@RequestMapping(value= "/uploadFile")
	public void uploadFile(@RequestParam MultipartFile file, Account account) {
		List<MultipartFile> fileList = account.getFiles();
		accountService.addFile(fileList, file);
		System.out.println("File uploaded!");
	}
	
	@RequestMapping(value = "/showFiles")
	public void showFiles(List<MultipartFile> fileList) {
		
	}
	
	@RequestMapping(value = "/deleteUser", method=RequestMethod.DELETE)
	public void deleteAccount(@RequestBody Account account) {
		accountService.deleteUser(account);
	}
}
