package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeakerMapper {
    int countByExample(SpeakerExample example);

    int deleteByExample(SpeakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Speaker record);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample(SpeakerExample example);

    Speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByExample(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByPrimaryKeySelective(Speaker record);

    int updateByPrimaryKey(Speaker record);

	int selectcountall(String userKeyWordname, String userKeyWordjob);

	List<Speaker> selectBypage(String userKeyWordname, String userKeyWordjob,int pag);
}