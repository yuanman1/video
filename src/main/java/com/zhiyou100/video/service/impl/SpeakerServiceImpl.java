package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerExample;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	private SpeakerMapper sm;

	@Override
	public Page<Speaker> findpageTRole(int page, String userKeyWordname, String userKeyWordjob) {
		
		int count=sm.selectcountall(userKeyWordname,userKeyWordjob);
		int pag =(page-1)*5;
		List<Speaker> li=sm.selectBypage(userKeyWordname,userKeyWordjob,pag);
		Page<Speaker> page1=new Page<>();
		page1.setPage(page);
		page1.setTotal(count);
		page1.setSize(5);
		page1.setRows(li);
		return page1;
	}

	@Override
	public void adminaddspeaker(Speaker speaker) {
		sm.insertSelective(speaker);
	}

	@Override
	public Speaker findadminupdatespeakerById(Integer id) {
		Speaker speaker = sm.selectByPrimaryKey(id);
		return speaker;
	}

	@Override
	public void adminupdatespeaker1(Speaker speaker) {
		SpeakerExample se=new SpeakerExample();
		se.createCriteria().andIdEqualTo(speaker.getId());
		sm.updateByExampleSelective(speaker, se);
	}

	@Override
	public void admindeletespeaker(Integer id) {
		sm.deleteByPrimaryKey(id);
		
	}
}
