package com.cdsc.spirngmvcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdsc.spirngmvcdemo.model.Post;
import com.cdsc.spirngmvcdemo.repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping("/postList")
	public Page<Post> getAllPosts(@RequestParam( defaultValue = "0", value=  "pageNo") int pageNo,
			                      @RequestParam(value= "size", defaultValue = "20") int size) {
		
		System.out.println("---------page size------ "+size);
		
		 Pageable pageable = PageRequest.of(pageNo, size);
		 Page<Post> page = postRepo.findAll(pageable);
		 
		return page;
	}

}
