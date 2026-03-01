package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.services.StudentServices;

@Controller
public class StudentController {

	@Autowired
	private StudentServices studentService;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/students")
	public String getAllStudents(Model model)
	{
		model.addAttribute("students", studentService.getAllStudent());
		return "student";
	}
	
	@GetMapping("students/new")
	public String addStudentForm(Model model)
	{
		Student student=new Student();
		model.addAttribute("students", student);
		return"add_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return"redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable int id,Model model)
	{
		model.addAttribute("student",studentService.getbyId(id));
		return"edit_student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStundent(@PathVariable int id, @ModelAttribute("student") Student student)
	{
		Student exitstudent=studentService.getbyId(id);
		
		exitstudent.setFirstName(student.getFirstName());
		exitstudent.setLastName(student.getLastName());
		exitstudent.setEmail(student.getEmail());
		exitstudent.setMoNo(student.getMoNo());
		
		studentService.saveStudent(exitstudent);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id)
	{
		studentService.deleteById(id);
		
		return "redirect:/students";
	}

	@PostMapping("/students/deleteAll")
public String deleteAllStudents() {
    studentService.deleteAllStudents();
    return "redirect:/students";
}
}
