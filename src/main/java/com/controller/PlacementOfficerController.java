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

import com.entity.PlacementOfficer;
import com.response.ResponseInfo;
import com.service.PlacementOfficerService;
import com.utility.GlobalResources;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PlacementOfficerController {
	
	@Autowired
	PlacementOfficerService placementOfficerService;
	private Logger logger = GlobalResources.getLogger(PlacementOfficerController.class);
	
	
	@PostMapping("/addPlacementOfficer")
	public ResponseEntity<ResponseInfo> addPlacementOfficer( @RequestBody PlacementOfficer placementOfficer, HttpServletRequest request ) {
		System.out.println(placementOfficer);
		String methodName = "addPlacementOfficer()";
		logger.info(methodName + "Called");
		
		String msg = placementOfficerService.addPlacementOfficer(placementOfficer);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),
				request.getRequestURI(),msg);
		ResponseEntity<ResponseInfo> rentity = new ResponseEntity<>(rinfo, HttpStatus.CREATED);
		return rentity;	
	}	
	
	@GetMapping("/placementOfficers")
	List<PlacementOfficer> getAllPlacementOfficers()
	{
		String methodName="getAllPlacementOfficers()";
		logger.info(methodName+"Called");
	return placementOfficerService.getAllPlacementOfficers();
	}
	
	@GetMapping("/placementOfficers/byId/{placementOfficerid}")
	PlacementOfficer getPlacementOfficer(@PathVariable("placementOfficerid") Long placementOfficerid)
	{
		String methodName="getPlacementOfficer()";
		logger.info(methodName+"Called");
	return placementOfficerService.getPlacementOfficer(placementOfficerid);
	}
	
	@DeleteMapping("/deletePlacementOfficer/{placementOfficerId}")
	ResponseEntity<ResponseInfo> deletePlacementOfficer(@PathVariable("placementOfficerId") Long placementOfficerId, HttpServletRequest request){
		boolean b=placementOfficerService.deletePlacementOfficer(placementOfficerId);
		String methodName="deletePlacementOfficer()";
		logger.info(methodName+"Called");
		String msg=null;
				if(b==true) {
					msg="Delete PlacementOfficer";
					}
				else {
				msg="PlacementOfficer not Deleted";
				}
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),request.getRequestURI(),msg);
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
		}
	@PutMapping("/placementOfficers")
	ResponseEntity<ResponseInfo> updatePlacementOfficer(@RequestBody PlacementOfficer placementOfficer, HttpServletRequest request){
		String methodName="updatePlacementOfficer()";
		logger.info(methodName+"Called");
	String msg=placementOfficerService.updatePlacementOfficer(placementOfficer);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),request.getRequestURI(),msg);
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	}
	

}
