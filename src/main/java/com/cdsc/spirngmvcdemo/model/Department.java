package com.cdsc.spirngmvcdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class Department {
	
	private String deptId;
	private String deptName;
	private String deptPhone;
	private String deptHead;
	
}
