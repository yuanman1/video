package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.AdminCourse;
@Service
public class AdminCourseImpl implements AdminCourse {
	
	@Autowired
	private CourseMapper cm;
	@Autowired
	private SubjectMapper sm;
	@Override
	public List<Course> findAllcourse() {
		List<Course> list=cm.findAllCourse();
		return list;
	}

	@Override
	public List<Subject> findAllsubject() {
		List<Subject> list = sm.selectByExample(null);
		return list;
	}

	@Override
	public void addcourse1(Course course) {
		cm.insertSelective(course);	
	}

	@Override
	public Course findcourseById(Integer id) {
		Course course = cm.selectByPrimaryKey(id);
		return course;
	}

	@Override
	public void updatecourse1(Course course) {
		CourseExample example=new CourseExample();
		example.createCriteria().andIdEqualTo(course.getId());
		cm.updateByExampleSelective(course, example);
		
	}

	@Override
	public void deletecourse(Integer id) {
		cm.deleteByPrimaryKey(id);
		
	}
}
