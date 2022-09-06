
package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {

	/*
	 * Faculty save(Faculty faculty);
	 * 
	 * List<Faculty> findAll();
	 * 
	 * Optional<Faculty> findAllById(Long facultyId);
	 * 
	 * void deleteAllById(Long facultyId);
	 * 
	 */

}
