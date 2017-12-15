package com.zhiyou100.video.web.controller;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.Success;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MailUtil;

@Controller
public class FrontUserController {
	
	@Autowired
	private FrontUserService fs;
	@RequestMapping(value="/front/user/login.action",method=RequestMethod.GET)
	public String frontlogin(){
	return "front/index";
	}
	@RequestMapping("/front/user/login.action")
	@ResponseBody
	public Success frontuserlogin(User user,Model md,HttpSession session){
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		List<User> list=fs.findFrontUserLogin(user);
		Success s=new Success();
		if(list.isEmpty()){
			s.setSuccess(false);
			s.setMessage("邮箱和密码不匹配！");
			return s;	
	     }
		for (User user2 : list) {
			session.setAttribute("user", user2);
			session.setAttribute("_front_user", user2);
			s.setSuccess(true);
		}
		return s;
	}
	@RequestMapping("/front/user/regist.action")
	@ResponseBody
	public Success frontuserregist(User user){
		Success s=new Success();
		List<User> list=fs.frontuserzhucejiaoyan(user.getEmail());
		if(list.size()>0){
			s.setSuccess(false);
			s.setMessage("邮件名已存在！");
			return s;
		}
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setInsertTime(new Date());
		fs.registUser(user);
		s.setSuccess(true);
	return s;
	}
	@RequestMapping("/front/user/index.action")
	public String frontuserindex(HttpServletRequest request,Model md,HttpSession session){
		User user = (User) request.getSession().getAttribute("_front_user");
		List<User> list=fs.findFrontUserLogin(user);
		for (User user2 : list) {
			session.setAttribute("user", user2);
		}
	return "front/user/index";
	}
	@RequestMapping("/front/user/logout.action")
	public String frontuserlogout(HttpServletRequest request){
		request.getSession().removeAttribute("_front_user");
		return "redirect:/front/user/login.action";
	}
	@RequestMapping("/front/user/tuichu.action")
	public String frontusertuichu(){
		return "front/index";
	}
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.GET)
	public String frontuserprofile(){
		return "front/user/profile";
	}
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
	public String changefrontuserprofile(User user,HttpServletRequest request){
		user.setUpdateTime(new Date());
		fs.changefrontuserprofile(user);
		return "redirect:/front/user/index.action";
	}
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.GET)
	public String frontuseravatar(){
		return "front/user/avatar";
	}
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
	public String test(MultipartFile image_file,HttpServletRequest request) throws Exception{
		User user = (User) request.getSession().getAttribute("_front_user");
		if(image_file.getOriginalFilename().equals("")){
			user.setHeadUrl("");
			fs.updateUserHeadUrl(user);
		}else{
		String st=UUID.randomUUID().toString().replaceAll("-", "");
		String ext=FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName=st+"."+ext;
		image_file.transferTo(new File("E:\\head_url\\"+fileName));
		user.setHeadUrl(fileName);
		fs.updateUserHeadUrl(user);
		}
		return "redirect:/front/user/index.action";
		
	}
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.GET)
	public String frontuserpassword(){
		return "front/user/password";
	}
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
	public String frontuserpassword1(String newPassword,String oldPassword,HttpServletRequest request,Model md){
		User user = (User) request.getSession().getAttribute("_front_user");
		user.setPassword(DigestUtils.md5DigestAsHex(oldPassword.getBytes()));
		List<User> list=fs.findFrontUserLogin(user);
		if(list.isEmpty()){
			md.addAttribute("error_pwd", "密码错误！！");
			return "front/user/password";
		}
		user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		fs.changeUserpwd(user);
		return "redirect:/front/user/index.action";
	}
	
	
	
	//---------------------------------忘记密码---------------------------------
	
	@RequestMapping(value="/front/user/forget.action",method=RequestMethod.GET)
	public String frontuserforget(){
		return "front/user/forget_pwd";
	}
	@RequestMapping("/front/user/sendemail.action")
	@ResponseBody
	public Success frontsendemail(String email) throws Exception{
		System.out.println(email);
		Success s=new Success();
		int a=(int)(Math.random()*1000000);
		List<User> list=fs.findUserByEmail(email);
		if(list.size()>0){
			fs.updateUserCaptcha(a,email);
			MailUtil.send(""+email,"智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！", "您好，智游教育在线公开课此次重置密码的验证码为："+a+",如果不是本人操作，请忽略本消息。");
			s.setSuccess(true);
		}else{
			s.setSuccess(false);
			s.setMessage("没有找到该邮件名！！");
		}
		return s;
	}
	@RequestMapping(value="/front/user/forget.action",method=RequestMethod.POST)
	public String frontuserforget1(User user,Model md){
		List<User> list=fs.findUserByForget(user);
		if(list.size()>0){
			md.addAttribute("email", user.getEmail());
			md.addAttribute("captcha", user.getCaptcha());
		return "front/user/reset_pwd";
		}
		md.addAttribute("error_forget", "邮箱名和验证码不匹配！");
		return "front/user/forget_pwd";
	}
	@RequestMapping("/front/user/resetpwd.action")
	public String frontuserresetpwd(User user){
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		fs.updateUserpwd(user);
		return "front/user/forget_pwd";
	}
	
	
	
}
