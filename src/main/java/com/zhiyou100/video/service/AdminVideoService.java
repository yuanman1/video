package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.utils.Page;

public interface AdminVideoService {

	List<Speaker> findAllByspeakername();

	List<Course> findAllBycoursename();

	Page<Video> findAllvideo(int page1, String video_title, String speaker_name, String course_name);

	void adminaddvideo1(Video video);

	Video findvideoById(Integer id);

	void adminupdatevideo1(Video video);

	void admindeletevideo(Integer id);


}
