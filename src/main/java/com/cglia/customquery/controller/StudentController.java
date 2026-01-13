package com.cglia.customquery.controller;

import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cglia.customquery.model.Student;
import com.cglia.customquery.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/viewStudents")
	public List<Student> list() {
		return studentService.listAll();
	}

	@GetMapping("/viewStudents/{id}")
	private Student getStudent(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

	@PostMapping("/addStudents")
	public String add(@RequestBody Student student) {
		studentService.save(student);
		return "Added successfully";
	}

	@PutMapping("/updateStudent/{id}")
	public String update(@PathVariable Long id, @RequestBody Student student) {
		studentService.update(id, student);
		return "updated successfully";
	}

	@DeleteMapping("/deleteStudents/{id}")
	public String delete(@PathVariable Long id) {
		studentService.delete(id);
		return "Deleted successfully";
	}

	@GetMapping("/age-less-than")
	public List<Student> getStudentsWithAgeLessThan(@RequestParam Integer age) {
		return studentService.getStudentsWithAgeLessThan(age);
	}

	@GetMapping("/age-greater-than")
	public List<Student> getStudentsWithAgeGreaterThan(@RequestParam Integer age) {
		return studentService.getStudentsWithAgeGreaterThan(age);
	}

	@GetMapping("/by-lastname-and-firstname")
	public List<Student> getStudentsByLastnameAndFirstname(@RequestParam String lastName,
			@RequestParam String firstName) {
		return studentService.getStudentsByLastnameAndFirstname(lastName, firstName);
	}

	@GetMapping("/by-firstname-like")
	public List<Student> getStudentsByFirstnameLike(@RequestParam String firstName) {
		return studentService.getStudentsByFirstnameLike(firstName);
	}

	@GetMapping("/by-lastname-or-firstname")
	public List<Student> findStudentsByLastNameOrFirstName(@RequestParam String lastName,
			@RequestParam String firstName) {
		return studentService.findStudentsByLastNameOrFirstName(lastName, firstName);
	}

	@GetMapping("/by-dob")
	public List<Student> findStudentsByDob(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob) {
		return studentService.findStudentsByDob(dob);
	}

	@GetMapping("/by-dob-between")
	public List<Student> findStudentsByDobBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dobFrom,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dobTo) {
		return studentService.findStudentsByDobBetween(dobFrom, dobTo);
	}

	@GetMapping("/by-firstname-ending")
	public List<Student> findByFirstnameEndingWith(@RequestParam String firstName) {
		return studentService.findByFirstnameEndingWith(firstName);
	}
}
