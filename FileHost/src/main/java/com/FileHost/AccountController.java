package com.FileHost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/{user}/{pass}")
	public String CheckIfUserExists(@PathVariable String user,@PathVariable String pass) {
		
	    Account account = new Account(user,pass);
		if(accountService.login(account)) {
			return("Login Success!");
		}
		else return ("Failed");
	}
	
	@RequestMapping("/allusers")
	public List<Account> getAllUsers(){
		return accountService.getAllUsers();
	}
	
	@RequestMapping(value = "/allusers",method=RequestMethod.POST)
	public void addUser(@RequestBody Account account) {
		//Account account=new Account(Username,Password);
		accountService.addUser(account);
	}

}
