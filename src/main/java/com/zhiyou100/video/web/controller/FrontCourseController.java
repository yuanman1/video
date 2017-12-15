package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.FrontCourseService;

@Controller
public class FrontCourseController {
	
	@Autowired
	private FrontCourseService fs;
	@RequestMapping("/front/course/index.action")
	public String frontcourseindex(Integer subjectId,Model md){
		Subject subject=fs.findSubjectName(subjectId);
		List<Course> list1 =fs.findCourseLists(subjectId);
		for (Course course : list1) {
			List<Video> video=fs.findVideoList(course.getId());
			for (Video video2 : video) {
				Integer seconds=video2.getVideo_length();
				int temp=0;
				StringBuffer sb=new StringBuffer();
				temp = seconds/3600;
				sb.append((temp<10)?"0"+temp+":":""+temp+":");
				temp=seconds%3600/60;
				sb.append((temp<10)?"0"+temp+":":""+temp+":");
				temp=seconds%3600%60;
				sb.append((temp<10)?"0"+temp:""+temp);
				video2.setVideoLengthStr(sb.toString());
			}
			course.setVideoList(video);
		}
		md.addAttribute("subject_id", subjectId);
		md.addAttribute("subject", subject);
		md.addAttribute("courses", list1);
		return "front/course/index";
	}
	
}
