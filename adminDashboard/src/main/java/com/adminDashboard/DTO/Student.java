package com.adminDashboard.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nev;
	private String neptun;
	
	@ManyToOne()
	@JoinColumn(name="teacher_id",nullable = false)  //generál a hibernate egy idegen kulcsot a teacher adattaghoz., Vagyis összeköti a Teacher táblával.
	private Teacher teacher;
	
public Student() {
		
	}
	
	public Student(int id, String nev, String neptun) {
		this.id = id;
		this.nev = nev;
		this.neptun = neptun;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getNeptun() {
		return neptun;
	}

	public void setNeptun(String neptun) {
		this.neptun = neptun;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
