package com.FileHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	private FileStorageService filestorageService;
	
	@RequestMapping("/{user}/{pass}")
	public String Login(@PathVariable String user,@PathVariable String pass) {
		if(accountService.login(user, pass)) {
			return("Login Success!");
		}
		else {
			return "Fail";
		}
	}
	
	
	@RequestMapping("/allusers")
	public List<Account> getAllUsers(){
		return accountService.getAllUsers();
	}
	
	@RequestMapping(value = "/signup",method=RequestMethod.POST)
	public void addUser(@RequestBody Account account) {
		accountService.addUser(account);
	}
	
	@RequestMapping(value= "/uploadFile", method=RequestMethod.POST)
	public void uploadFile(@RequestParam MultipartFile file, @RequestParam Account account) {
		List<MultipartFile> fileList = account.getFiles();
		filestorageService.addFile(fileList, file);
		System.out.println("File uploaded!");
	}
	
	@RequestMapping(value="/downloadFile", method=RequestMethod.POST)
	public MultipartFile downloadFile(@RequestParam String filename, @RequestParam Account account) {
		List<MultipartFile> fileList = account.getFiles();
		return filestorageService.findFile(fileList, filename);
		
	}
	@RequestMapping(value = "/showFiles", method=RequestMethod.GET)
	public void showFiles(Account account) {
		filestorageService.showFiles(account);
		
	}
	
	@RequestMapping(value = "/deleteUser", method=RequestMethod.DELETE)
	public void deleteAccount(@RequestBody Account account) {
		accountService.deleteUser(account);
	}
}
