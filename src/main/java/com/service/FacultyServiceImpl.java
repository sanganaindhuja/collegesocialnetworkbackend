

package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Faculty;
import com.entity.Student;
import com.exception.FacultyNotFoundException;
import com.repository.FacultyRepo;
import com.utility.GlobalResources;
@Service
public class FacultyServiceImpl implements FacultyService {
	
	@Autowired
	FacultyRepo facultyRepo;
	private Logger logger = GlobalResources.getLogger(FacultyService.class);

	@Override
	public String addFaculty(Faculty Faculty) {
	Faculty F = facultyRepo.save(Faculty);
		if (!(F == null))
			return "Inserted Successfully";
		else
			return "Unable To Insert";
	}

	@Override
	public List<Faculty> getAllFaculty() {
		String methodName = "getFaculty()";
		logger.info(methodName + "Called");
		return facultyRepo.findAll();
	}
	
	public Faculty getFaculty(Long FacultyId) {
		String methodName="getAdmin()";
		logger.info(methodName+"Called");
		Optional<Faculty> op = facultyRepo.findById(FacultyId);
		if (op.isPresent())
			return op.get();
		else
			throw new FacultyNotFoundException("Faculty not found for this Id:" + FacultyId);		
	}
	
	@Override
	public boolean deleteFaculty(Long FacultyId) {
		String methodName="deleteFaculty()";
		logger.info(methodName+"Called");
		Optional<Faculty> op=facultyRepo.findById(FacultyId);
		if(op.isPresent()) {
			facultyRepo.deleteById(FacultyId);
		return true;
		}else
	return false;
			
	}
	@Override
	public String updateFaculty(long l, Faculty Faculty) {
		String methodName="updateFaculty()";
		logger.info(methodName+"Called");
		Faculty vc=facultyRepo.save(Faculty);
		if(!(vc==null))
			return "Faculty Updated Successfully";
		else
			return "Faculty Unable To Update";
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(Long studentid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	public static IntPredicate addfaculty(Faculty c1) {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public List<Faculty> getFaculty() {
//		// TODO Auto-generated method stub
//		return null;
//	}




}



