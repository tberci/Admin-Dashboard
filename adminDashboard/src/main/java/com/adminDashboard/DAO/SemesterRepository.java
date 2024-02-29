package com.adminDashboard.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminDashboard.DTO.Semester;

@Repository
public interface SemesterRepository  extends CrudRepository<Semester, Integer>{

	public List<Semester> findAll();
	public List<Semester> findById(Long id);
	
}
