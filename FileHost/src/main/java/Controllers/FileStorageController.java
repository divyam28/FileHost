package Controllers;

import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Services.FileStorageService;

@RestController
public class FileStorageController {
	
	@Autowired
	private FileStorageService filestorageService;

	
	@RequestMapping(value= "/uploadFile", method=RequestMethod.POST)
	public void uploadFile(@RequestPart MultipartFile file, @RequestParam String username) {
		filestorageService.uploadFile(file, username);
		System.out.println("File uploaded!");
	}
	
	@RequestMapping(value="/downloadFile", method=RequestMethod.POST)
	public Path downloadFile(@RequestParam String filename, @RequestParam String username) {
		return filestorageService.downloadFile(filename,username);
		
	}
	@RequestMapping(value = "/showFiles", method=RequestMethod.GET)
	public void showFiles(@RequestParam String username) {
		filestorageService.showFiles(username);
		
	}
	
	@RequestMapping(value = "/deleteFile", method=RequestMethod.DELETE)
	public void deleteFile(@RequestParam String filename,@RequestParam String username) {
		filestorageService.deleteFile(filename, username);
	}
	

}
