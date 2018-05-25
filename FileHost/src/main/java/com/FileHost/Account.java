package com.FileHost;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Document(collection="Accounts")
@Data
public class Account {
	
	@Id
	private String _id;
	private String Username;
	private String Password;
	private String Email;
	
	private List<MultipartFile> Files;	
	
	public Account(String username, String password) {
		super();
		this.Username = username;
		this.Password = password;
	}

	public Account() {
		//constructor
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
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
	
	public List<MultipartFile> getFiles() {
		return Files;
	}
	
	public void setFiles(List<MultipartFile> files) {
		this.Files = files;
	}
	
	
	
	
	

}
