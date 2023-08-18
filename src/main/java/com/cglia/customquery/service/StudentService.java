package com.cglia.customquery.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.customquery.model.Student;
import com.cglia.customquery.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> listAll() {
		return studentRepository.findAll();
	}

	public void save(Student student) {
		studentRepository.save(student);
	}

	public void delete(Long id) {
		studentRepository.deleteById(id);

	}
	  public String update(Long id, Student student) {
	        Optional<Student> existingStudentOptional = studentRepository.findById(id);
	        
	        if (existingStudentOptional.isPresent()) {
	            Student existingStudent = existingStudentOptional.get();
	            existingStudent.setFirstName(student.getFirstName());
	            existingStudent.setLastName(student.getLastName());
	            existingStudent.setAge(student.getAge());
	            existingStudent.setEmail(student.getEmail());
	            existingStudent.setDob(student.getDob());
	            existingStudent.setPhone(student.getPhone());
	            existingStudent.setCreatedBy(student.getCreatedBy());
	            
	            studentRepository.save(existingStudent);
	            return "Updated successfully";
	        } else {
	            return "Student with ID " + id + " not found";
	        }
	    }

	public Student getStudentById(Long id) {
			return studentRepository.findById(id).get();  
	}
	
	  public List<Student> getStudentsWithAgeLessThan(Integer age) {
	        return studentRepository.findStudentsWithAgeLessThan(age);
	    }

	    public List<Student> getStudentsByLastnameAndFirstname(String lastName, String firstName) {
	        return studentRepository.findStudentsByLastnameAndFirstname(lastName, firstName);
	    }

	    public List<Student> getStudentsByFirstnameLike(String firstName) {
	        return studentRepository.findStudentsByFirstnameLike(firstName);
	    }
	    
	    public List<Student> findStudentsByLastNameOrFirstName(String lastName, String firstName) {
	        return studentRepository.findStudentsByLastnameOrFirstname(lastName, firstName);
	    }

		public List<Student> getStudentsWithAgeGreaterThan(Integer age) {
			return studentRepository.findStudentsWithAgeGreaterThan(age);
		}
		
		public List<Student> findStudentsByDob(Date dob) {
		    return studentRepository.findStudentsByDob(dob);
		}
		
		public List<Student> findStudentsByDobBetween(Date dobFrom, Date dobTo) {
		    return studentRepository.findStudentsByDobBetween(dobFrom, dobTo);
		}
		
		public List<Student> findByFirstnameEndingWith(String firstName) {
		    return studentRepository.findByFirstnameEndingWith(firstName);
		}

}
