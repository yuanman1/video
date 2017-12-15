package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.admin;

public interface AdminUserService {

	List<admin> findUserByName(admin user);

}
