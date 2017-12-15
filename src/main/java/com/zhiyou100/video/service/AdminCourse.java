package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;

public interface AdminCourse {

	List<Course> findAllcourse();

	List<Subject> findAllsubject();

	void addcourse1(Course course);

	Course findcourseById(Integer id);

	void updatecourse1(Course course);

	void deletecourse(Integer id);

}
