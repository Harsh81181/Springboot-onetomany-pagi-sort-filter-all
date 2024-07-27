package com.ibm.springboot_onetomany_mapping.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.ibm.springboot_onetomany_mapping.dto.Student;
import com.ibm.springboot_onetomany_mapping.dto.Subject;
import com.ibm.springboot_onetomany_mapping.repository.StudentRepository;
import com.ibm.springboot_onetomany_mapping.repository.SubjectRepository;

@Repository
public class StudentSubjectDao {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Student saveStudentSubjectDao(Student student) {
		List<Subject> subjects=student.getSubjects();
		student.setSubjects(null);
		for(Subject subject:subjects) {
			subject.setStudent(student);
//			subjectRepository.save(subject);
		}
		student.setSubjects(subjects);
		return studentRepository.save(student);
	}
	
	public Student getStudentSubjectsbyStudentIdDao(int studentId) {
		Optional<Student> optional =studentRepository.findById(studentId);
		if(optional!=null) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public Subject saveSubjectByStudentIdDao(int id,Subject subject) {
		Student student=studentRepository.findById(id).orElse(null);
		if(student!=null) {
			subject.setStudent(student);
			subject =subjectRepository.save(subject);
		}
		return subject;
	}
	
	public List<Subject> saveMultipleSubjectByStudentId(int id,List<Subject> subjects) {
		Student student=studentRepository.findById(id).orElse(null);
		if(student!=null) {
			for(Subject subject:subjects) {
				subject.setStudent(student);
			}
			subjectRepository.saveAll(subjects);
		}
		return subjects;
	}
	
	public List<Subject> getAllSubjectSortByIdDesc(String sortColumn){
		return subjectRepository.findAll(Sort.by(Direction.DESC,sortColumn));
	}
	
	public List<Subject> filterByName(String name){
		List<Subject> subjects=subjectRepository.findAll();
		return subjects.stream().filter(a->a.getName()
				.equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}
	
	public Page<Subject> paginationWithName(int pageNumber,int pageSize,String sortColumn){
		return subjectRepository.findAll(PageRequest.of(pageNumber, pageSize, Direction.ASC, sortColumn));
	}
	
	public Page<Subject> filterPaginationWithColumnName(int pageNumber,int pageSize,String filterColumnName){
		return subjectRepository.findByAuthor(PageRequest.of(pageNumber, pageSize), filterColumnName);
	}
}
