package com.FileHost;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	public List<MultipartFile> showFiles(Account account);
	public void addFile(List<MultipartFile> fileList, MultipartFile file);
	public void deleteFile(List<MultipartFile> fileList, MultipartFile file);
	public void downloadFile(List<MultipartFile> fileList, MultipartFile file);
	public MultipartFile findFile(List<MultipartFile> fileList, String filename);
}
