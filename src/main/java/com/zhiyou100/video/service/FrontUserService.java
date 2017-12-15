package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.User;

public interface FrontUserService {

	List<User> findFrontUserLogin(User user);

	void registUser(User user);

	List<User> frontuserzhucejiaoyan(String name);

	void changefrontuserprofile(User user);

	User findUser(Integer id);

	void updateUserHeadUrl(User user);

	void changeUserpwd(User user);

	List<User> findUserByEmail(String email);

	void updateUserCaptcha(int a, String email);

	List<User> findUserByForget(User user);

	void updateUserpwd(User user);


}
