package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.utils.Page;
@Service
public class AdminVideoServiceImpl implements AdminVideoService {
	
	@Autowired
	private VideoMapper vm;

	@Override
	public List<Speaker> findAllByspeakername() {
		List<Speaker> speaker=vm.findAllByspeakername();
		return speaker;
	}

	@Override
	public List<Course> findAllBycoursename() {
		List<Course> course=vm.findAllBycoursename();
		return course;
	}

	@Override
	public Page<Video> findAllvideo(int page1, String video_title, String speaker_name, String course_name) {
		int count=vm.selectcountall(video_title,speaker_name,course_name);
	    int pag =(page1-1)*5;
	    List<Video> li=vm.selectBypage(video_title,speaker_name,course_name,pag);
	    Page<Video> page2=new Page<>();
		page2.setPage(page1);
		page2.setTotal(count);
		page2.setSize(5);
		page2.setRows(li);
		return page2;
	}

	@Override
	public void adminaddvideo1(Video video) {
		vm.insertSelective(video);
		
	}

	@Override
	public Video findvideoById(Integer id) {
		Video video = vm.selectByPrimaryKey(id);
		return video;
	}

	@Override
	public void adminupdatevideo1(Video video) {
		VideoExample example=new VideoExample();
		example.createCriteria().andIdEqualTo(video.getId());
		vm.updateByExampleSelective(video, example);
		
	}

	@Override
	public void admindeletevideo(Integer id) {
		vm.deleteByPrimaryKey(id);
		
	}

	
}
