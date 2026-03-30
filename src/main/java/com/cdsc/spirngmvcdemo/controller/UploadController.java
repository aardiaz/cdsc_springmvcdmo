package com.cdsc.spirngmvcdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String getUploadPage() {
		
		return "UploadForm";
	}
	
	@PostMapping("/upload")
	public String postUpload(@RequestParam("image") MultipartFile image, Model model) throws IOException {
		
		if(!image.isEmpty()) {
			
			long  imgSize = image.getSize()/1024; // size in KB
			
			if(imgSize > 500) {
				model.addAttribute("message", "File size should be less than 500KB ! Your file size is : "+imgSize+" KB");
				return "UploadForm";
			}
			
			String fileType = image.getOriginalFilename().split("\\.")[1];
			if (!fileType.equalsIgnoreCase("jpg") && !fileType.equalsIgnoreCase("jpeg")
					&& !fileType.equalsIgnoreCase("png")) {
				model.addAttribute("message",
						"Only JPG, JPEG and PNG files are allowed ! Your file type is : " + fileType);
				return "UploadForm";
			}
			
			
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			model.addAttribute("message", "File uploaded successfully: "+image.getOriginalFilename());
			
			
			
			return "UploadForm";
		}
		
		model.addAttribute("message", "File uploaded failed !");
		return "UploadForm";
	}

	
}
