package com.student.services;

import java.util.List;

import com.student.entity.Student;


public interface StudentServices {

	public List<Student> getAllStudent();
	public Student saveStudent(Student student);
	public Student getbyId(int id);
	public void deleteById(int id);
	public void deleteAllStudents();
}
