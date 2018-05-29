package Services;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	public Path showFiles(String username);
	public void uploadFile(MultipartFile file,String username);
	public void deleteFile(String filename,String username);
	public Path downloadFile(String filename, String username);
}
