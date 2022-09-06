package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	
	
}
