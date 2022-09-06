package com.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.usertype.UserType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Admin;
import com.repository.AdminRepository;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	private AdminService adminservice;

	@MockBean
	private AdminRepository adminrepo;

	@Test
	void TestAddDetails() {
		Admin admin = new Admin();
		admin.setEmailId("Sanju@gmail.com");

		admin.setFirstName("Sanju");
		admin.setpassword("Sanju@99805");

		//admin.setUsertype(UserType.Admin);
		Mockito.when(adminrepo.save(admin)).thenReturn(admin);
		assertThat(adminservice.AddDetails(admin)).isEqualTo(admin);
	}
	//
//		@Test
//		void testDeleteRegister() {
//			
//			Admin admin = new Admin();
//			admin.setEmail("Sanju@gmail.com");
//			
//			admin.setName("sanju");
//			admin.setPassword("Sanju@99805");
//			
//			admin.setUsertype(UserType.AUTHOR);
//			Mockito.when(adminrepo.delete(admin.getRegistrationNumber() & admin.getPassw).thenReturn(admin);
//			
//			//
//			
//		}

	@Test
	void TestGetDetails() {
		Admin admin = new Admin();

		admin.setFirstName("Sanju");
		admin.setpassword("Sanju@99805");

		// admin.setUsertype(UserType.Admin);

		Admin admin1 = new Admin();

		admin1.setFirstName("Suraj");
		admin1.setpassword("Suraj@99805");

		List<Admin> addAdmin = new ArrayList<>();
		addAdmin.add(admin1);
		addAdmin.add(admin);

		Mockito.when(adminrepo.findAll()).thenReturn(addAdmin);
		assertThat(adminservice.getDetails()).isEqualTo(addAdmin);
	}

	@Test
	  void TestUpdateAdminDetails() throws Throwable {
		Admin admin1 = new Admin();

		admin1.setFirstName("Suraj");
		admin1.setpassword("Suraj@99805");
		// admin1.setUsertype(UserType.admin);
		Mockito.when(adminrepo.findByRegistrationNumber(42345l)).thenReturn(admin1);

		Mockito.when(adminrepo.save(admin1)).thenReturn(admin1);
		assertThat(adminservice.updateAdminDetails(admin1, 42345l)).isEqualTo(admin1);
	}

}
