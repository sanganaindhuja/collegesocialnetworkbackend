package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.exception.StudentIdNotFoundException;
import com.repository.StudentRepo;
import com.utility.GlobalResources;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo studentRepo;
	private Logger logger = GlobalResources.getLogger(StudentService.class);

	@Override
	public String addStudent(Student student) {
		Student p = studentRepo.save(student);
		if (!(p == null))
			return "Inserted Successfully";
		else
			return "Unable To Insert";
	}

	@Override
	public List<Student> getAllStudents() {
		String methodName = "getAllStudents()";
		logger.info(methodName + "Called");
		return studentRepo.findAll();
	}
	
	public Student getStudent(Long studentId) {
		String methodName="getStudent()";
		logger.info(methodName+"Called");
		Optional<Student> op = studentRepo.findById(studentId);
		if (op.isPresent())
			return op.get();
		else
			throw new StudentIdNotFoundException("Student not found for this Id:" + studentId);
	}
	
	@Override
	public boolean deleteStudent(Long studentId) {
		String methodName="deleteStudent()";
		logger.info(methodName+"Called");
		Optional<Student> op=studentRepo.findById(studentId);
		if(op.isPresent()) {
			studentRepo.deleteById(studentId);
		return true;
		}else
	return false;
			
	}
	@Override
	public String updateStudent(Student student) {
		String methodName="updateStudent()";
		logger.info(methodName+"Called");
		Student vc=studentRepo.save(student);
		if(!(vc==null))
			return "Student Updated Successfully";
		else
			return "Student Unable To Update";
	}



}
