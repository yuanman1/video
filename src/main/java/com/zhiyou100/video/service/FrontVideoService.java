package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;

public interface FrontVideoService {

	Video findVideoUser(Integer videoId);

	Speaker findSpeakerUser(Integer speaker_id);

	Course findCourseUser(Integer course_id);

	List<Video> findVideoList(Integer id);

	Speaker findSpeakerName(Integer speaker_id);

	void updateVideovideo_play_times(Integer videoId, Integer integer);

}
