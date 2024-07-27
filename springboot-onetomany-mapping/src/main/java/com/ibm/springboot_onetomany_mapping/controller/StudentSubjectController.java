package com.ibm.springboot_onetomany_mapping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot_onetomany_mapping.dao.StudentSubjectDao;
import com.ibm.springboot_onetomany_mapping.dto.Student;
import com.ibm.springboot_onetomany_mapping.dto.Subject;
@RestController
public class StudentSubjectController {
	@Autowired
	private StudentSubjectDao dao;
	@PostMapping("/saveStudentSubejct")
	public Student saveStudentSubjectController(@RequestBody Student student) {
		return dao.saveStudentSubjectDao(student);
	}
	@GetMapping("/getStudentSubject/{studentId}")
	public Student getStudentSubjectsbyStudentIdDao(@PathVariable int studentId) {
		return dao.getStudentSubjectsbyStudentIdDao(studentId);
	}
	@PostMapping("/saveSubjectByStudentId/{id}")
	public Subject saveSubjectByStudentId(@PathVariable int id,@RequestBody Subject subject) {
		return dao.saveSubjectByStudentIdDao(id, subject);
}
	@PostMapping("/saveMultipleSubjectByStudentId/{id}")
	public List<Subject> saveMultipleSubjectByStudentId(@PathVariable int id,@RequestBody List<Subject> subjects) {
		return dao.saveMultipleSubjectByStudentId(id, subjects);
	}
	@GetMapping("/getAllSubjectSortByIdDesc/{sortColumn}")
	public List<Subject> getAllSubjectSortByIdDesc(@PathVariable String sortColumn){
		return dao.getAllSubjectSortByIdDesc(sortColumn);
	}
	@GetMapping("/filterByName/{name}")
	public List<Subject> filterByName(String name){
		return dao.filterByName(name);
	}
	@GetMapping("/paginationWithcolumn/{pageNumber}/{pageSize}/{sortColumn}")
	public Page<Subject> paginationWithName(int pageNumber,int pageSize,String sortColumn){
		return dao.paginationWithName(pageNumber, pageSize, sortColumn);
	}
	@GetMapping("/filterPaginationWithColumnName/{pageNumber}/{pageSize}/{authorName}")
	public Page<Subject> filterPaginationWithColumnName(int pageNumber,int pageSize,String authorName){
		return (Page<Subject>) dao.filterPaginationWithColumnName(pageNumber, pageSize, authorName);
	}


}

