package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminStatisticsService;
@Service
public class AdminStatisticsServiceImpl implements AdminStatisticsService {
	
	@Autowired
	private VideoMapper vm;
	@Autowired
	private CourseMapper cm;

	@Override
	public List<Course> findVideoByCourseName() {
		List<Course> list = cm.selectByExample(null);
		return list;
	}

	@Override
	public Integer findVideoByVideoTims(Course course) {
		Integer a=vm.findVideoByVideoTims(course.getId());
		return a;
	}
	
}
