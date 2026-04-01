package com.cdsc.spirngmvcdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "post_tbl")
public class Post {
	@Id
	private Long id;
	private String userId;
	private String title;
	private String body;
}
