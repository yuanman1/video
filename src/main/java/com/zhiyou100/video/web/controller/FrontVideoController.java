package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.FrontCourseService;
import com.zhiyou100.video.service.FrontVideoService;

@Controller
public class FrontVideoController {
	@Autowired
	private FrontCourseService fs;
	@Autowired
	private FrontVideoService fvs;
	@RequestMapping("/front/video/index.action")
	public String frontuserresetpwd(Integer videoId,Integer subjectId,Model md){
		Subject subject=fs.findSubjectName(subjectId);
		Video video=fvs.findVideoUser(videoId);
		fvs.updateVideovideo_play_times(videoId,video.getVideo_play_times());
		Speaker speaker=fvs.findSpeakerUser(video.getSpeaker_id());
		Course course=fvs.findCourseUser(video.getCourse_id());
		List<Video> list=fvs.findVideoList(course.getId());
		for (Video video2 : list) {
			Speaker speaker1=fvs.findSpeakerName(video2.getSpeaker_id());
			if(speaker1!=null){
				video2.setSpeaker_name(speaker1.getSpeaker_name());
			}
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
		md.addAttribute("subject", subject);
		md.addAttribute("videoId", videoId);
		md.addAttribute("video", video);
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		md.addAttribute("subjectId", subjectId);
		md.addAttribute("videoList", list);
		return "front/video/index";
	}
	
}
