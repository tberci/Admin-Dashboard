package com.adminDashboard.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adminDashboard.DTO.Milestone;
import com.adminDashboard.DTO.Semester;
import com.adminDashboard.DTO.Student;
import com.adminDashboard.DTO.Teacher;
import com.adminDashboard.Service.DaoService;



@Controller
public class MainController {

	@Autowired
	private DaoService service;
	
	
	
	@GetMapping(value="/")
	public ModelAndView getDashboard()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.html");
		mav.addObject("teachers", service.listTeachers());
		mav.addObject("semesters", service.listSemesters());
		mav.addObject("milestones", service.listMilestones());
		mav.addObject("students", service.listStudents());
		return mav;
	}
	
	
	@GetMapping(value="/addSemester")
	public ModelAndView getAddSemester()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semester.html");
		
		return mav;
	}
	
	@PostMapping(value="/addSemester")
	public ModelAndView addSemester(Semester semester)  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.html");
		mav.addObject("semesters", service.saveSemester(semester));
		return mav;
	}
	
	@GetMapping(value="/addMilestone")
	public ModelAndView getAddMilestone()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("milestone.html");
		
		return mav;
	}
	
	@PostMapping(value="/addMilestone")
	public ModelAndView addMilestone(Milestone milestone)  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.html");
		mav.addObject("milestones",service.saveMilestone(milestone));
		
		return mav;
	}
	
	
	@GetMapping(value="/addTeacher")
	public ModelAndView getAddTeacher()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("teacher.html");
		
		return mav;
	}
	
	
	@PostMapping(value="/addTeacher")
	public ModelAndView addTeacher(Teacher teacher)  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.html");
		mav.addObject("teachers", service.saveTeacher(teacher));
	
		return mav;
	}
	
	@GetMapping(value="/deleteSemester")
	public ModelAndView getDelete()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteSemester.html");
		
		return mav;
	}
	
	@PostMapping(value="/deleteSemester")
	public ModelAndView deleteSemester(int id)  {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.html");
		
			service.removeSemester(id);
	
		return mav;
	}

	@GetMapping(value="/addStudent")
	public ModelAndView getAddStudent()  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student.html");
		
		return mav;
	}
	
	@PostMapping(value="/addStudent")
	public ModelAndView addStudent(Student student)  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("student", service.saveStudent(student));
		return mav;
	}
	
	
	@PostMapping(value="/findById", params="id")
	public ModelAndView findSemester(@RequestParam int id)  {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		mav.addObject("semesterid", service.findById(id));
		return mav;
	}
	
	
}
