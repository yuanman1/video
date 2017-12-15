package com.zhiyou100.video.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.service.AdminUserService;
import com.zhiyou100.video.utils.MD5Utils;

@Controller
public class AdminUserController {
	@Autowired
	private AdminUserService as;
	@RequestMapping(value="/admin/login.action",method=RequestMethod.GET)
	public String adminlogin(){
	return "admin/login";
	}
	@RequestMapping(value="/admin/login.action",method=RequestMethod.POST)
	public String adminlogin1(admin user,Model md,HttpSession session){
		//user.setLogin_pwd(MD5Utils.md5(user.getLogin_pwd()));
		user.setLogin_pwd(DigestUtils.md5DigestAsHex(user.getLogin_pwd().getBytes()));  
		List<admin> list= as.findUserByName(user);
		if(list.isEmpty()){
			md.addAttribute("errorMessage", "用户名密码不匹配");
			return "forward:/WEB-INF/view/admin/login.jsp";	
	     }
		for (admin admin : list) {
			session.setAttribute("LOGIN_USER", admin);
		}
		return "admin/header";
	}
	@RequestMapping("/admin/logout.action")
	public String adminlogout(HttpServletRequest request){
		request.getSession().removeAttribute("LOGIN_USER");
		
	return "admin/login";
	}
}
