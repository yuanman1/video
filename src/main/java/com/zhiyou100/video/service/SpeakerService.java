package com.zhiyou100.video.service;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.utils.Page;

public interface SpeakerService {

	Page<Speaker> findpageTRole(int page, String userKeyWordname, String userKeyWordjob);

	void adminaddspeaker(Speaker speaker);

	Speaker findadminupdatespeakerById(Integer id);

	void adminupdatespeaker1(Speaker speaker);

	void admindeletespeaker(Integer id);

}
