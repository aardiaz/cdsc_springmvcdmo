package com.cdsc.spirngmvcdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="department_tbl")
public class Department {
	@Id
	private String deptId;
	private String deptName;
	private String deptPhone;
	private String deptHead;
}
