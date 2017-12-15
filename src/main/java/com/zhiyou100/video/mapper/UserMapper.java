package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	void changeUserpwd(String pwd, Date updateTime, String email);

	void updateUserCaptcha(int a, String email);

	void updateUserHeadUrl(String head_url, String email);

	void updateUserpwd(String pwd, String email);
}