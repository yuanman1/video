package com.zhiyou100.video.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.FrontUserService;
@Service
public class FrontUserServiceImpl implements FrontUserService {
	
	@Autowired
	private UserMapper um;

	@Override
	public List<User> findFrontUserLogin(User user) {
		UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());
		List<User> list = um.selectByExample(example);
		return list;
	}

	@Override
	public void registUser(User user) {
		um.insertSelective(user);
		
	}

	@Override
	public List<User> frontuserzhucejiaoyan(String name) {
		UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(name);
		List<User> list = um.selectByExample(example);
		return list;
	}

	@Override
	public void changefrontuserprofile(User user) {
		UserExample example=new UserExample();
		example.createCriteria().andIdEqualTo(user.getId());
		um.updateByExampleSelective(user, example);
		
	}

	@Override
	public User findUser(Integer id) {
		User user = um.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public void updateUserHeadUrl(User user) {
		String email=user.getEmail();
		String head_url=user.getHeadUrl();
		um.updateUserHeadUrl(head_url,email);
		
	}

	@Override
	public void changeUserpwd(User user) {
		Date UpdateTime=new Date();
		String email=user.getEmail();
		String pwd=user.getPassword();
		um.changeUserpwd(pwd,UpdateTime,email);
		
	}

	@Override
	public List<User> findUserByEmail(String email) {
		UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> list = um.selectByExample(example);
		return list;
	}

	@Override
	public void updateUserCaptcha(int a, String email) {
		um.updateUserCaptcha(a,email);
		
	}

	@Override
	public List<User> findUserByForget(User user) {
		UserExample example=new UserExample();
		example.createCriteria().andEmailEqualTo(user.getEmail()).andCaptchaEqualTo(user.getCaptcha());
		List<User> list = um.selectByExample(example);
		return list;
	}

	@Override
	public void updateUserpwd(User user) {
		String email=user.getEmail();
		String pwd=user.getPassword();
		um.updateUserpwd(pwd,email);
	}
}
