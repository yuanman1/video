package com.zhiyou100.video.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("obj", arg2);
		mav.addObject("error", arg3);
		mav.setViewName("forward:/WEB-INF/view/admin/error.jsp");
		return mav;
	}

}
