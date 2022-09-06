package com.service;

import java.util.List;

import com.entity.Student;



public interface StudentService {
	String  addStudent(Student student);
    List<Student> getAllStudents();
	boolean deleteStudent(Long studentId);
	Student getStudent(Long studentid);
    String updateStudent(Student student);


}
