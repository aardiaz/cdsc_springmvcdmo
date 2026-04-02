package com.cdsc.spirngmvcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdsc.spirngmvcdemo.model.Post;
import com.cdsc.spirngmvcdemo.repository.PostRepository;

@Controller
public class IndexController {
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping("/posts")
	public String getPosts(Model model, @RequestParam(defaultValue = "0", value = "page") int pageNo,@RequestParam(defaultValue = "20", value = "pageSize") int pageSize) {

		System.out.println("---------page size------ "+pageSize);
		//Pageable  pageable = PageRequest.of(pageNo, pageSize);
		
		   Page<Post> page = postRepo.findAll(PageRequest.of(pageNo, pageSize));
		   model.addAttribute("postPage", page);
		   model.addAttribute("currentPage", pageNo);
		   
		return "PostListForm";
	}
	
//	@GetMapping("/")
//	public String getIndex() {
//		
//		return "Index";
//	}
}
