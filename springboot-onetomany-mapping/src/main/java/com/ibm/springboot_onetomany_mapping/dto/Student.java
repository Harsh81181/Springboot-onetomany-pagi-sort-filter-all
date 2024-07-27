package com.ibm.springboot_onetomany_mapping.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Student implements Serializable{
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Subject> subjects;
}
