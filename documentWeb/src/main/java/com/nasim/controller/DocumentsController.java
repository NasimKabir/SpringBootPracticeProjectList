package com.nasim.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nasim.model.Documents;
import com.nasim.repository.DocumentsRepository;

@Controller
public class DocumentsController {
	@Autowired
	private DocumentsRepository documentsRepository;

	@GetMapping("/")
	public String DocumentsPage(Model model) {
		List<Documents>getDocuments=documentsRepository.findAll();
		model.addAttribute("getDocuments", getDocuments);
		return "documents";
	}
	@PostMapping("/upload")
	public String Uploads(@RequestParam("document")MultipartFile file,Documents document) {
		 document.setName(file.getOriginalFilename());
		 try {
			document.setData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 document=documentsRepository.save(document);
		return "redirect:/";
	}

}
