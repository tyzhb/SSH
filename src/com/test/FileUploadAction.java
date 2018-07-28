package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private File uploadFile; //文件
	private String uploadFileContentType;
	private String uploadFileFileName;
	
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String uploadfile() throws Exception {
		InputStream is = new FileInputStream(uploadFile);
		
		System.out.println(image.getName());
		
		byte[] img = new byte[1024 * 100];
		byte[] buff = new byte[1024];

		int length = 0;
		int strLen2 = 0;
		while ((length = is.read(buff)) > 0) {
			System.arraycopy(buff, 0, img, strLen2, length);// 将第二个数组与第一个数组合并
			strLen2 += length;
			System.out.println(img);
		}
		
		return "success";

		/*
		 * String uploadPath = ServletActionContext.getServletContext()
		 * .getRealPath("/upload");
		 * 
		 * File toFile = new File(uploadPath, this.getUploadFileFileName());
		 * OutputStream os = new FileOutputStream(toFile); byte[] buffer = new
		 * byte[1024]; int length = 0; while ((length = is.read(buffer)) > 0) {
		 * os.write(buffer, 0, length); System.out.println(buffer); }
		 * is.close(); os.close(); return "success";
		 */
	}
}
