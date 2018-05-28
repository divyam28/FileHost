package com.FileHost;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileStorageServiceImp implements FileStorageService{
	
	@Override
	public List<MultipartFile> showFiles(Account account) {
		List<MultipartFile> fileList = account.getFiles();
		return fileList;
	}

	@Override
	public void addFile(List<MultipartFile> fileList, MultipartFile file) {
		fileList.add(file);
		
	}
	
	@Override
	public MultipartFile findFile(List<MultipartFile> fileList, String filename) {
		for(MultipartFile f : fileList) {
			String fname = f.getOriginalFilename();
			if (fname.equals(filename)){
				return f;
			}
		}
		return null;
	}

	@Override
	public void deleteFile(List<MultipartFile> fileList, MultipartFile file) {
		fileList.remove(file);
		
	}
	
	@Override
	public void downloadFile(List<MultipartFile> fileList, MultipartFile file) {
		
	}
	
}
