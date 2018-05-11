package com.FileHost;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="Accounts")
@Data
public class Account {
	
	private String Id;
	private String Username;
	private String Password;
	private String Email;
	
	public Account(String username, String password) {
		super();
		this.Username = username;
		this.Password = password;
	}

	public Account() {
		//constructor
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
	
	
	
	
	

}
