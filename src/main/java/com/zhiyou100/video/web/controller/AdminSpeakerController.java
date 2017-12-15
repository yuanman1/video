package com.zhiyou100.video.web.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;


@Controller
public class AdminSpeakerController {
	
	@Autowired
	private SpeakerService ss;
	@RequestMapping("/admin/speakerlist.action")
	/*public String adminspeakerlist(Model md,Page pag,Speaker speaker,String userKeyWordname,String userKeyWordjob){
		int page=pag.getPage();
		page=page==0?1:page;
		userKeyWordname = userKeyWordname==null?"":userKeyWordname;
		userKeyWordjob = userKeyWordjob==null?"":userKeyWordjob;*/
	public String adminspeakerlist(Model md,@RequestParam(defaultValue="1")Integer page,Speaker speaker,@RequestParam(defaultValue="")String userKeyWordname,@RequestParam(defaultValue="")String userKeyWordjob){
		Page<Speaker> a=ss.findpageTRole(page,userKeyWordname,userKeyWordjob);
		md.addAttribute("page", a);
		md.addAttribute("userKeyWordname", userKeyWordname);
		md.addAttribute("userKeyWordjob", userKeyWordjob);
		  
	return "admin/speaker/speakerlist";
	}
	@RequestMapping(value="/admin/addspeaker.action",method=RequestMethod.GET)
	public String adminaddspeaker(){
		return "admin/speaker/addspeaker";
	}
	@RequestMapping(value="/admin/addspeaker.action",method=RequestMethod.POST)
	public String adminaddspeaker1(Speaker speaker){
		Date date=new Date();
		speaker.setInsert_time(date);
		ss.adminaddspeaker(speaker);
		return "redirect:/admin/speakerlist.action";
	}
	@RequestMapping(value="/admin/updatespeaker.action",method=RequestMethod.GET)
	public String adminupdatespeaker(Integer id,Model md){
		Speaker speaker=ss.findadminupdatespeakerById(id);
		md.addAttribute("speaker", speaker);
		return "admin/speaker/updatespeaker";
	}
	@RequestMapping(value="/admin/updatespeaker.action",method=RequestMethod.POST)
	public String adminupdatespeaker1(Speaker speaker){
		Date date=new Date();
		speaker.setUpdate_time(date);
		ss.adminupdatespeaker1(speaker);
		return "redirect:/admin/speakerlist.action";
	}
	@RequestMapping("/admin/deletespeaker.action")
	public String admindeletespeaker(Integer id){
		ss.admindeletespeaker(id);
		return "redirect:/admin/speakerlist.action";
	}
	
}
