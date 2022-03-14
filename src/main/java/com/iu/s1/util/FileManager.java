package com.iu.s1.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	public String save(MultipartFile file) throws Exception {
		String realPath = servletContext.getRealPath(path);
		
		return "";
	}
}
