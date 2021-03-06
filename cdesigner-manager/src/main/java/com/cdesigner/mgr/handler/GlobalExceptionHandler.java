package com.cdesigner.mgr.handler;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cdesigner.mgr.WebBase;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * 
 * @version 1.0.0
 * @since 2015年7月4日 下午11:36:57
 */
public class GlobalExceptionHandler extends WebBase implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		log.error("Handler : " + handler + " Error.", ex);
		ModelAndView mv = createModelView("error");
		if (ex != null) {
		    mv.addObject("status", 500);
	        mv.addObject("messageList", Arrays.asList(ExceptionUtils.getStackFrames(ex)));
		} else {
		    mv.addObject("status", 400);
	        mv.addObject("messageList", Arrays.asList("系统响应异常!"));
		}
		return mv;
	}
}