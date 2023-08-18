package com.cglia.customquery.repository;

import java.util.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cglia.customquery.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT s FROM Student s WHERE s.age < ?1")
	List<Student> findStudentsWithAgeLessThan(Integer age);

	@Query("SELECT s FROM Student s WHERE s.age > ?1")
	List<Student> findStudentsWithAgeGreaterThan(Integer age);

	@Query("SELECT s FROM Student s WHERE s.lastName = ?1 AND s.firstName = ?2")
	List<Student> findStudentsByLastnameAndFirstname(String lastName, String firstName);

	@Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1%")
	List<Student> findStudentsByFirstnameLike(String firstName);

	@Query("SELECT s FROM Student s WHERE s.lastName = ?1 OR s.firstName = ?2")
	List<Student> findStudentsByLastnameOrFirstname(String lastName, String firstName);

	@Query("SELECT s FROM Student s WHERE s.dob = ?1")
	List<Student> findStudentsByDob(Date dob);

	@Query("SELECT s FROM Student s WHERE s.dob BETWEEN ?1 AND ?2")
	List<Student> findStudentsByDobBetween(Date dobFrom, Date dobTo);

	@Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1")
	List<Student> findByFirstnameEndingWith(String firstName);

}
