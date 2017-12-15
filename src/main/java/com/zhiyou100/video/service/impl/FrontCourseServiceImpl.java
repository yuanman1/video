package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.FrontCourseService;
@Service
public class FrontCourseServiceImpl implements FrontCourseService {
	
	@Autowired
	private CourseMapper cm;
	@Autowired
	private SubjectMapper sm;
	@Autowired
	private VideoMapper vm;
	@Override
	public Subject findSubjectName(Integer subjectId) {
		Subject subject = sm.selectByPrimaryKey(subjectId);
		return subject;
	}
	@Override
	public List<Course> findCourseLists(Integer subjectId) {
		CourseExample example=new CourseExample();
		example.createCriteria().andSubject_idEqualTo(subjectId);
		List<Course> course = cm.selectByExample(example);
		return course;
	}
	@Override
	public List<Video> findVideoList(Integer id) {
		VideoExample example=new VideoExample();
		example.createCriteria().andCourse_idEqualTo(id);
		List<Video> list = vm.selectByExample(example);
		return list;
	}
	
}
