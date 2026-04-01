package com.cdsc.spirngmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdsc.spirngmvcdemo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	
}
