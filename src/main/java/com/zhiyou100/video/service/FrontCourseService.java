package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;

public interface FrontCourseService {
	Subject findSubjectName(Integer subjectId);

	List<Course> findCourseLists(Integer subjectId);

	List<Video> findVideoList(Integer id);


}
