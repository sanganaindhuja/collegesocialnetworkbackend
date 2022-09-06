
package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Admin;
import com.exception.AdminIdNotFoundException;

import com.repository.AdminRepository;
import com.utility.GlobalResources;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepo;
	private Logger logger = GlobalResources.getLogger(AdminService.class);

	@Override
	public String addAdmin(Admin Admin) {
		Admin a = adminRepo.save(Admin);
		if (!(a == null))
			return "Inserted Successfully";
		else
			return "Unable To Insert";
	}

	@Override
	public List<Admin> getAllAdmins() {
		String methodName = "getAdmins()";
		logger.info(methodName + "Called");
		return adminRepo.findAll();
	}

	public Admin getAdmin(Long AdminId) {
		String methodName = "getAdmin()";
		logger.info(methodName + "Called");
		Optional<Admin> op = adminRepo.findById(AdminId);
		if (op.isPresent())
			return op.get();
		else
			throw new AdminIdNotFoundException("Admin not found for this Id:" + AdminId);
	}

	@Override
	public boolean deleteAdmin(Long AdminId) {
		String methodName = "deleteAdmin()";
		logger.info(methodName + "Called");
		Optional<Admin> op = adminRepo.findById(AdminId);
		if (op.isPresent()) {
			adminRepo.deleteById(AdminId);
			return true;
		} else
			return false;

	}

	@Override
	public String updateAdmin(Admin Admin) {
		String methodName = "updateAdmin()";
		logger.info(methodName + "Called");
		Admin vc = adminRepo.save(Admin);
		if (!(vc == null))
			return "Admin Updated Successfully";
		else
			return "Admin Unable To Update";
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
