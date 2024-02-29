package com.adminDashboard.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semester")
public class Semester {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "semester")
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "semester")
	private List<Milestone> milestones;
	
	
	
	public Semester() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public List<Milestone> getMilestones() {
		return milestones;
	}


	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}
	
	
	
	
}
