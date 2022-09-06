package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;
import java.util.function.IntPredicate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Faculty;
import com.repository.FacultyRepo;

@SpringBootTest
class FacultyServiceImplTest {
	@Autowired
	private FacultyServiceImpl facultyServiceImpl;

	@MockBean
	FacultyRepo repo;

	@Test

	void TestAddFaculty() {
		Faculty c1 = new Faculty();
		c1.setFacultyId((long) 1);
		c1.setAdminName("Aditya");
		c1.setFacultyName("adi");

		Mockito.when(repo.save(c1)).thenReturn(c1);

		assertThat(FacultyServiceImpl.addfaculty(c1)).isEqualTo(c1);
	}

	@Test
	void TestUpdateFaculty() throws Throwable {
		Faculty c1 = new Faculty();
		c1.setFacultyId((long) 1);
		c1.setAdminName("sumit");
		c1.setFacultyame("Sumit");

		Optional<Faculty> c2 = Optional.of(c1);

		Mockito.when(repo.findById((long) 1)).thenReturn(c2);

		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setAdminName("Madhulika");
		c1.setFacultyName("Madhu");

		assertThat(facultyServiceImpl((long) 1, c1)).isEqualTo(c1);
	}

	

	
	

	private IntPredicate facultyServiceImpl(long l, Faculty c1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void TestGetFacultyById() throws Throwable {
		Faculty c1 = new Faculty();
		c1.setFacultyId((long) 1);
	
		c1.setAdminName("Usman");
		c1.setFacultyName("Usman");
		Optional<Faculty> c2 = Optional.of(c1);
		Mockito.when(repo.findById((long) 1)).thenReturn(c2);
		assertThat(facultyServiceImpl.getFaculty((long) 1)).isEqualTo(c1);
	}

	@Test
	void TestDeleteAdminById() {
		Faculty c1 = new Faculty();
		c1.setFacultyId((long) 1);
		c1.setAdminName("Raju");
		c1.setFacultyName("raju");
		Optional<Faculty> c2 = Optional.of(c1);
		Mockito.when(repo.findById((long) 1)).thenReturn(c2);
		Mockito.when(repo.existsById(c1.getFaculty())).thenReturn(false);
		assertFalse(repo.existsById(c1.getFaculty()));
	}
}