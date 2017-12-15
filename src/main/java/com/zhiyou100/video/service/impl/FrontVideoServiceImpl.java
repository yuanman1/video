package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.FrontVideoService;
@Service
public class FrontVideoServiceImpl implements FrontVideoService {
	
	@Autowired
	private VideoMapper vm;
	@Autowired
	private SpeakerMapper sm;
	@Autowired
	private CourseMapper cm;
	@Override
	public Video findVideoUser(Integer videoId) {
		Video video = vm.selectByPrimaryKey(videoId);
		return video;
	}
	@Override
	public Speaker findSpeakerUser(Integer speaker_id) {
		Speaker speaker = sm.selectByPrimaryKey(speaker_id);
		return speaker;
	}
	@Override
	public Course findCourseUser(Integer course_id) {
		Course course = cm.selectByPrimaryKey(course_id);
		return course;
	}
	@Override
	public List<Video> findVideoList(Integer id) {
		VideoExample example=new VideoExample();
		example.createCriteria().andCourse_idEqualTo(id);
		List<Video> list = vm.selectByExample(example);
		return list;
	}
	@Override
	public Speaker findSpeakerName(Integer speaker_id) {
		Speaker speaker = sm.selectByPrimaryKey(speaker_id);
		return speaker;
	}
	@Override
	public void updateVideovideo_play_times(Integer videoId, Integer integer) {
		Integer a=integer+1;
		vm.updateVideovideo_play_times(a,videoId);
		
	}
	
	
}
