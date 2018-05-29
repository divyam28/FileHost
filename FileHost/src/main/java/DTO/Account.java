package DTO;

import java.nio.file.Path;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection="Accounts")
@Data
public class Account {
	
	@Id
	private String _id;
	private String Username;
	private String Password;
	private String Email;
	private Path Folder;	
	
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

	public Path getFolder() {
		return Folder;
	}

	public void setFolder(Path folder) {
		Folder = folder;
	}
	
	
	
	
	

}
