

	package com.service;

	import java.util.List;
import java.util.function.IntPredicate;

import com.entity.Admin;
import com.entity.PlacementOfficer;

	public interface AdminService {
		String  addAdmin(Admin Admin);
	    List<Admin> getAdmins();
		boolean deleteAdmin(Long AdminId);
		Admin getAdmin(Long id);
	    String updateAdmin(Admin Admin);

		IntPredicate AddDetails(Admin admin);
		IntPredicate updateAdminDetails(Admin admin1, long l);
		IntPredicate getDetails();
		

	}


