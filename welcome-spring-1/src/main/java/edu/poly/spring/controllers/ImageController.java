package edu.poly.spring.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {
	@GetMapping("/upload")
	public String upload() {
		return "uploadForm";
	}
	@PostMapping("/upload")
	public String upload(ModelMap model, @RequestParam("image") MultipartFile image) {
		if (image.isEmpty()) {
			model.addAttribute("message", "Please upload an image!");
		}
		Path path = Paths.get("images/");
		try (InputStream is = image.getInputStream()){
			Files.copy(is, path.resolve(image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			String filename = image.getOriginalFilename();
			model.addAttribute("message", filename + " uploaded !!! ");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Error: "+e.getMessage());
		}
		return "uploadForm";
	}
	
}
