package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.adminMapper;
import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.model.adminExample;
import com.zhiyou100.video.service.AdminUserService;
@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired
	private adminMapper am;

	@Override
	public List<admin> findUserByName(admin user) {
		adminExample min=new adminExample();
		min.createCriteria().andLogin_nameEqualTo(user.getLogin_name()).andLogin_pwdEqualTo(user.getLogin_pwd());
		List<admin> list = am.selectByExample(min);
		return list;
	}
}
