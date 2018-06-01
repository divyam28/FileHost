package Services;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import DTO.Account;
import Exceptions.ResponseCode;
import Exceptions.UtilityException;
import Repository.AccountRepository;

public class FileStorageServiceImp implements FileStorageService{
	
	private static String MASTER_FOLDER = "//src//main//java//Storage//";
	private AccountRepository accountRepository;
	
	
	

	@Override
	public void uploadFile(MultipartFile file,String username) {
		if(file.isEmpty()) {
			throw new UtilityException(ResponseCode.EMPTY_FILE);
		}
		Path folderpath = Paths.get(MASTER_FOLDER + username);
		Account account = accountRepository.findByUsername(username);
		
		if(Files.notExists(folderpath)){
			try {
				account.setFolder(folderpath);
				Files.createDirectory(folderpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Path filepath = Paths.get(folderpath + file.getOriginalFilename());
			Files.copy(file.getInputStream(), filepath, REPLACE_EXISTING);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Path showFiles(String username) {
		Account account = accountRepository.findByUsername(username);
		return account.getFolder();
	}
	
	@Override
	public Path downloadFile(String filename,String username) {
		Account account = accountRepository.findByUsername(username);
		Path path = account.getFolder();
		Path filepath = Paths.get(path + filename);
		if(Files.exists(filepath)) {
			return filepath;
		}
		else {
			throw new UtilityException(ResponseCode.FILE_DOES_NOT_EXIST);
		}	
	}

	@Override
	public void deleteFile(String username,String filename) {
		Account account = accountRepository.findByUsername(username);
		Path path = account.getFolder();
		Path filepath = Paths.get(path + filename);
		if(Files.exists(filepath)) {
			try {
				Files.delete(filepath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			throw new UtilityException(ResponseCode.FILE_DOES_NOT_EXIST);
		}
	}
	
}
