package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.response.ResponseInfo;
import com.service.StudentService;




import com.utility.GlobalResources;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	private Logger logger = GlobalResources.getLogger(StudentController.class);
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<ResponseInfo> addStudent( @RequestBody Student student, HttpServletRequest request ) {
		System.out.println(student);
		String methodName = "addStudent()";
		logger.info(methodName + "Called");
		
		String msg = studentService.addStudent(student);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),
				request.getRequestURI(),msg);
		ResponseEntity<ResponseInfo> rentity = new ResponseEntity<>(rinfo, HttpStatus.CREATED);
		return rentity;	
	}	
	
	@GetMapping("/students")
	List<Student> getAllStudents()
	{
		String methodName="getAllStudents()";
		logger.info(methodName+"Called");
	return studentService.getAllStudents();
	}
	
	@GetMapping("/students/byId/{studentid}")
	Student getStudent(@PathVariable("studentid") Long studentid)
	{
		String methodName="getStudent()";
		logger.info(methodName+"Called");
	return studentService.getStudent(studentid);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	ResponseEntity<ResponseInfo> deleteStudent(@PathVariable("studentId") Long studentId, HttpServletRequest request){
		boolean b=studentService.deleteStudent(studentId);
		String methodName="deleteStudent()";
		logger.info(methodName+"Called");
		String msg=null;
				if(b==true) {
					msg="Delete Student";
					}
				else {
				msg="Student not Deleted";
				}
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),request.getRequestURI(),msg);
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
		}
	@PutMapping("/students")
	ResponseEntity<ResponseInfo> updateStudent(@RequestBody Student student, HttpServletRequest request){
		String methodName="updateStudent()";
		logger.info(methodName+"Called");
	String msg=studentService.updateStudent(student);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),request.getRequestURI(),msg);
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	}
	

	
}
