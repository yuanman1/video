package com.zhiyou100.video.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.AdminCourse;

@Controller
public class AdminCourseController {
	
	@Autowired
	private AdminCourse ac;
	@RequestMapping("/admin/course.action")
	public String admincourse(Model md){
		List<Course> course=ac.findAllcourse();
		md.addAttribute("list", course);
	return "admin/course/courselist";
	}
	@RequestMapping(value="/admin/addcourse.action",method=RequestMethod.GET)
	public String addcourse(Model md){
		
		List<Subject> list=ac.findAllsubject();
		md.addAttribute("list", list);
	return "admin/course/addcourse";
	}
	@RequestMapping(value="/admin/addcourse.action",method=RequestMethod.POST)
	public String addcourse1(Course course){
		Date date=new Date();
		course.setInsert_time(date);
		ac.addcourse1(course);
	return "redirect:/admin/course.action";
	}
	@RequestMapping(value="/admin/updatecourse.action",method=RequestMethod.GET)
	public String updatecourse(Integer id,Model md){
		Course course=ac.findcourseById(id);
		List<Subject> list = ac.findAllsubject();
		md.addAttribute("list", list);
		md.addAttribute("course", course);
	return "admin/course/updatecourse";
	}
	@RequestMapping(value="/admin/updatecourse.action",method=RequestMethod.POST)
	public String updatecourse1(Course course){
		Date date=new Date();
		course.setUpdate_time(date);
		ac.updatecourse1(course);
	return "redirect:/admin/course.action";
	}
	@RequestMapping("/admin/deletecourse.action")
	public String deletecourse(Integer id){
		ac.deletecourse(id);
		return "redirect:/admin/course.action";
	}
}
