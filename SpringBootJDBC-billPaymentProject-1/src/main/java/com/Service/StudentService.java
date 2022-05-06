package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.Beans.Student;
import com.Repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll() {
		return repo.findAll();
	}
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public Student get(long sid) {
		return repo.findById(sid).get();
	}
	
	public void delete(long sid) {
		repo.deleteById(sid);
	}
}
