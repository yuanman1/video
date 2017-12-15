package com.zhiyou100.video.mapper;

import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.model.adminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface adminMapper {
    int countByExample(adminExample example);

    int deleteByExample(adminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(admin record);

    int insertSelective(admin record);

    List<admin> selectByExample(adminExample example);

    admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") admin record, @Param("example") adminExample example);

    int updateByExample(@Param("record") admin record, @Param("example") adminExample example);

    int updateByPrimaryKeySelective(admin record);

    int updateByPrimaryKey(admin record);
}