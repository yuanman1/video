package com.zhiyou100.video.web.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.service.AdminStatisticsService;


@Controller
public class AdminStatisticsController {

	@Autowired
	private AdminStatisticsService ass;
	
	@RequestMapping("/admin/statisticslist.action")
	public String admincourse(Model md){
		List<Integer> list=new ArrayList<Integer>();
		List<Course> li=ass.findVideoByCourseName();
		md.addAttribute("course", li);
		
		for (Course course : li) {
			Integer count =ass.findVideoByVideoTims(course);
			list.add(count);
		}
		md.addAttribute("times", list);
	return "admin/statistics/statisticslist";
	}
}
