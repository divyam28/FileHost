package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTO.Account;
import Services.AccountService;

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
	
	
	@RequestMapping("/allusers")
	public List<Account> getAllUsers(){
		return accountService.getAllUsers();
	}
	
	@RequestMapping(value = "/signup",method=RequestMethod.POST)
	public void addUser(@RequestBody Account account) {
		accountService.addUser(account);
	}
	
	@RequestMapping(value = "/deleteUser", method=RequestMethod.DELETE)
	public void deleteAccount(@RequestBody Account account) {
		accountService.deleteUser(account);
	}
	
	
}
