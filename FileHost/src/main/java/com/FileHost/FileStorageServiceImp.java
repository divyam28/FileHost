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
	public void deleteFile(List<MultipartFile> fileList, MultipartFile file) {
		fileList.remove(file);
		
	}
	
	@Override
	public void downloadFile(List<MultipartFile> fileList, MultipartFile file) {
		
	}
	
}
