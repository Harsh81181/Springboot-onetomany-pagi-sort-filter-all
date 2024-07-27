package com.ibm.springboot_onetomany_mapping.dto;

import java.io.Serializable;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject  implements Serializable{
	@Id
	private int id;
	private String name;
	private String author;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
}
