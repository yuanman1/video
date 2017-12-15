package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	List<Speaker> findAllByspeakername();

	List<Course> findAllBycoursename();

	int selectcountall(@Param("video_title") String video_title,@Param("speaker_name") String speaker_name,@Param("course_name") String course_name);

	List<Video> selectBypage(@Param("video_title") String video_title,@Param("speaker_name") String speaker_name,@Param("course_name") String course_name,@Param("pag") int pag);

	Integer findVideoByVideoTims(Integer id);

	void updateVideovideo_play_times(Integer a, Integer videoId);
}