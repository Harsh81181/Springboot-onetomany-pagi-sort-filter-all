package com.ibm.springboot_onetomany_mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.springboot_onetomany_mapping.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
