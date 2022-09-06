package com.service;

import java.util.List;

import com.entity.PlacementOfficer;

public interface PlacementOfficerService {
	String  addPlacementOfficer(PlacementOfficer placementOfficer);
    List<PlacementOfficer> getAllPlacementOfficers();
	boolean deletePlacementOfficer(Long placementOfficerId);
	PlacementOfficer getPlacementOfficer(Long placementOfficerid);
    String updatePlacementOfficer(PlacementOfficer placementOfficer);


}
