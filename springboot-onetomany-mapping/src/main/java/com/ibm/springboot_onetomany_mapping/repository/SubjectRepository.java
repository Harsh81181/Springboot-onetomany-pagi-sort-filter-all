package com.ibm.springboot_onetomany_mapping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.springboot_onetomany_mapping.dto.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	public Page<Subject> findByAuthor(PageRequest pageRequest,String author);
}
