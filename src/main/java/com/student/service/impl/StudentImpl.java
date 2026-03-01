package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.services.StudentServices;

@Service
public class StudentImpl implements StudentServices {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getbyId(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 studentRepository.deleteById(id);
	}

	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}


}
