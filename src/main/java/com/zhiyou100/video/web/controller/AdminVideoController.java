package com.zhiyou100.video.web.controller;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminVideoService;
import com.zhiyou100.video.utils.Page;

@Controller
public class AdminVideoController {
	
	@Autowired
	private AdminVideoService as;
	
	@RequestMapping("/admin/videolist.action")
	/*public String adminvideolist(Model md,Page page,String video_title,String speaker_name,String course_name){
		int page1=page.getPage()==0?1:page.getPage();
		video_title = video_title==null?"":video_title;
		speaker_name = speaker_name==null?"":speaker_name;
		course_name = course_name==null?"":course_name;*/
	public String adminvideolist(Model md,@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="")String video_title,@RequestParam(defaultValue="")String speaker_name,@RequestParam(defaultValue="")String course_name){
		List<Speaker> speaker=as.findAllByspeakername();
		List<Course> course=as.findAllBycoursename();
		Page<Video> a=as.findAllvideo(page,video_title,speaker_name,course_name);
		md.addAttribute("page", a);
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
	return "admin/video/videolist";
	}
	@RequestMapping(value="/admin/addvideo.action",method=RequestMethod.GET)
	public String adminaddvideo(Model md){
		List<Speaker> speaker=as.findAllByspeakername();
		List<Course> course=as.findAllBycoursename();
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
	return "admin/video/addvideo";
	}
	@RequestMapping(value="/admin/addvideo.action",method=RequestMethod.POST)
	public String adminaddvideo1(Video video){
		Date date=new Date();
		video.setInsert_time(date);
		as.adminaddvideo1(video);
		return "redirect:/admin/videolist.action";
	}
	@RequestMapping(value="/admin/updatevideo.action",method=RequestMethod.GET)
	public String adminupdatevideo(Model md,Integer id){
		List<Speaker> speaker=as.findAllByspeakername();
		List<Course> course=as.findAllBycoursename();
		Video video=as.findvideoById(id);
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		md.addAttribute("video", video);
	return "admin/video/updatevideo";
	}
	@RequestMapping(value="/admin/updatevideo.action",method=RequestMethod.POST)
	public String adminupdatevideo1(Video video){
		Date date=new Date();
		video.setUpdate_time(date);
		as.adminupdatevideo1(video);
		return "redirect:/admin/videolist.action";
	}
	@RequestMapping("/admin/deletevideo.action")
	public String admindeletevideo(Integer id){
		as.admindeletevideo(id);
		return "redirect:/admin/videolist.action";
	}
	@RequestMapping("/admin/deleteallvideo.action")
	public String admindeleteallvideo(int[] id){
		if(id==null){
			return "redirect:/admin/videolist.action";
		}
		for (int i : id) {
			as.admindeletevideo(i);
		}
		return "redirect:/admin/videolist.action";
	}
}
