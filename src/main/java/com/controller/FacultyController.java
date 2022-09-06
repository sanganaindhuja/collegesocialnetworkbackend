
package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.entity.Faculty;

import com.response.ResponseInfo;
import com.service.FacultyService;
import com.utility.GlobalResources;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;
	private Logger logger = GlobalResources.getLogger(FacultyController.class);
	
	
	@PostMapping("/addfaculty")
	public ResponseEntity<ResponseInfo> addFaculty( @RequestBody Faculty faculty, HttpServletRequest request ) {
		System.out.println(faculty);
		String methodName = "addFaculty()";
		logger.info(methodName + "Called");
		
		String msg = facultyService.addFaculty(faculty);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),
				request.getRequestURI(),msg);
		ResponseEntity<ResponseInfo> rentity = new ResponseEntity<>(rinfo, HttpStatus.CREATED);
		return rentity;	
	}	
	
	@GetMapping("/facultys")
	List<Faculty> getAllFaculty()
	{
		String methodName="getFaculty()";
		logger.info(methodName+"Called");
	return facultyService.getAllFaculty();
	}
	
	@GetMapping("/facultys/byId/{facultyid}")
	Faculty getFaculty(@PathVariable("facultyid") Long facultyid)
	{
		String methodName="getFaculty()";
		logger.info(methodName+"Called");
	return facultyService.getFaculty(facultyid);
	}
	
	@DeleteMapping("/deleteFaculty/{facultyId}")
	ResponseEntity<ResponseInfo> deleteFacultyr(@PathVariable("facultyId") Long facultyId, HttpServletRequest request){
		boolean b=facultyService.deleteFaculty(facultyId);
		String methodName="deleteFaculty()";
		logger.info(methodName+"Called");
		String msg=null;
				if(b==true) {
					msg="Delete Faculty";
					}
				else {
				msg="Faculty not Deleted";
				}
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),request.getRequestURI(),msg);
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
		}
	@PutMapping("/facultys")
	ResponseEntity<ResponseInfo> updateFaculty(@RequestBody Faculty faculty, HttpServletRequest request){
		String methodName="updateFaculty()";
		logger.info(methodName+"Called");
	String msg=facultyService.updateFaculty(faculty);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),request.getRequestURI(),msg);
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	}
	

}
