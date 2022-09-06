package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.PlacementOfficer;
import com.exception.PlacementOfficerIdNotFoundException;
import com.repository.PlacementOfficerRepo;
import com.utility.GlobalResources;
@Service
public class PlacementOfficerServiceImpl implements PlacementOfficerService {
	@Autowired
	PlacementOfficerRepo placementOfficerRepo;
	private Logger logger = GlobalResources.getLogger(PlacementOfficerService.class);

	@Override
	public String addPlacementOfficer(PlacementOfficer placementOfficer) {
		PlacementOfficer p = placementOfficerRepo.save(placementOfficer);
		if (!(p == null))
			return "Inserted Successfully";
		else
			return "Unable To Insert";
	}

	@Override
	public List<PlacementOfficer> getAllPlacementOfficers() {
		String methodName = "getAllPlacementOfficers()";
		logger.info(methodName + "Called");
		return placementOfficerRepo.findAll();
	}
	
	public PlacementOfficer getPlacementOfficer(Long placementOfficerId) {
		String methodName="getPlacementOfficer()";
		logger.info(methodName+"Called");
		Optional<PlacementOfficer> op = placementOfficerRepo.findById(placementOfficerId);
		if (op.isPresent())
			return op.get();
		else
			throw new PlacementOfficerIdNotFoundException("PlacementOfficer not found for this Id:" + placementOfficerId);
	}
	
	@Override
	public boolean deletePlacementOfficer(Long placementOfficerId) {
		String methodName="deletePlacementOfficer()";
		logger.info(methodName+"Called");
		Optional<PlacementOfficer> op=placementOfficerRepo.findById(placementOfficerId);
		if(op.isPresent()) {
			placementOfficerRepo.deleteById(placementOfficerId);
		return true;
		}else
	return false;
			
	}
	@Override
	public String updatePlacementOfficer(PlacementOfficer placementOfficer) {
		String methodName="updatePlacementOfficer()";
		logger.info(methodName+"Called");
		PlacementOfficer vc=placementOfficerRepo.save(placementOfficer);
		if(!(vc==null))
			return "PlacementOfficer Updated Successfully";
		else
			return "PlacementOfficer Unable To Update";
	}




}
