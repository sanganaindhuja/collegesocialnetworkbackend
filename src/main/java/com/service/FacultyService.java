

package com.service;

import java.util.List;


import com.entity.Faculty;
import com.entity.Student;


public interface FacultyService {
	String  addFaculty(Faculty Faculty);
    //List<Faculty> getFaculty();
	boolean deleteFaculty(Long FacultyId);
	
    String updateFaculty(Faculty Faculty);
    	List<Student> getAllStudents();
		Student getStudent(Long studentid);
		boolean deleteStudent(Long studentId);
		String updateStudent(Student student);
		String addStudent(Student student);
		List<Faculty> getAllFaculty();
		Faculty getFaculty(Long facultyid);
		String updateFaculty(long l, Faculty Faculty);

}


