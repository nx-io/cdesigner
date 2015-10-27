package com.cdesigner.mgr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.cdesigner.constant.GlobalProperties;
import com.cdesigner.dao.AdminDAO;
import com.cdesigner.dao.SystemSettingDAO;
import com.cdesigner.domain.Admin;
import com.cdesigner.mgr.req.ViewRequest;
import com.cdesigner.mgr.utils.Utils;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * 
 * @version 1.0.0
 * @since 2015年7月4日 下午11:38:04
 */
public class WebBase implements ServletContextAware {

	protected Log log = LogFactory.getLog(getClass());
	
	@Resource
	protected SystemSettingDAO systemSettingDAO;
	
	@Resource
	protected AdminDAO adminDAO;

	@Autowired
	@Qualifier("multipartResolver")
	protected CommonsMultipartResolver multipartResolver;

	private ServletContext servletContext;
	
    @Autowired
    protected HttpServletRequest request;
	
    @Autowired
    protected HttpServletResponse response;
    
	protected ModelAndView createModelView(String viewName) {
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("cdn", "/assets/");
        mv.addObject("cdnDomain", GlobalProperties.CDN_DOMAIN);
		mv.addObject("viewname", viewName);
		return mv;
	}

	protected ModelAndView createModelView(String viewName, ViewRequest req) {
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("cdn", "/assets/");
        mv.addObject("cdnDomain", GlobalProperties.CDN_DOMAIN);
		mv.addObject("utils", new Utils());
		mv.addObject("viewname", StringUtils.defaultIfBlank(req.getV(), viewName));
		return mv;
	}
	
	protected void returnJson(JSONObject json) {
		PrintWriter out = null;
		try {
			response.setContentType("application/json; charset=UTF-8");
			out = response.getWriter();
			out.write(json.toString());
			out.flush();
		} catch (IOException e) {
			log.error("Return JSON Error.", e);
		} finally {
			if(out != null) {
				out.close();
				out = null;
			}
		}
	}
	
	protected void returnJson(boolean success, String code, String message) {
		try {
			JSONObject json = new JSONObject();
			json.accumulate("success", success);
			json.accumulate("code", code);
			json.accumulate("message", message);
			returnJson(json);
		} catch (Throwable e) {
			log.error("Return JSON Error.", e);
		}
	}
	
	protected long getAdminId() {
		Object admin = SecurityUtils.getSubject().getPrincipal();
		if (admin == null) {
			return 0L;
		}
		return ((Admin) admin).getId();
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}