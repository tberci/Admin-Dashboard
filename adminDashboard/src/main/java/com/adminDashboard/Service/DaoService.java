package com.adminDashboard.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminDashboard.DAO.MilestoneRepository;
import com.adminDashboard.DAO.SemesterRepository;
import com.adminDashboard.DAO.StudentRepository;
import com.adminDashboard.DAO.TeacherRepository;
import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;

@Service
public class DaoService implements ServiceInterface {

	@Autowired
	private SemesterRepository srepo;
	
	@Autowired
	private TeacherRepository trepo;
	
	@Autowired
	private MilestoneRepository mrepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	
	@Override
	public Semester saveSemester(Semester semester) {
		return srepo.save(semester);
	}
	@Override
	public List<Semester> listSemesters() {
		return srepo.findAll();
	}
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return trepo.save(teacher);
	}
	@Override
	public List<Teacher> listTeachers() {
		return trepo.findAll();
	}
	@Override
	public Milestone saveMilestone(Milestone milestone) {
		return mrepo.save(milestone);
	}
	@Override
	public List<Milestone> listMilestones() {
		return mrepo.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	@Override
	public List<Student> listStudents() {
		return studentRepo.findAll();
	}
	@Override
	public String removeSemester(int id) {
		srepo.deleteById(id);
		return "semester deleted" +id;
	}
	
	@Override
	 public Optional<Semester> findById(int id) {

	        return srepo.findById(id);
	    }
}
