package com.cdesigner.mgr.req;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * 
 * @version 1.0.0
 * @since 2015年7月4日 下午7:02:30
 */
public class ContestListRequest extends PageRequest {
	
	private String title;

	private String status;

	@Override
	protected ContestListRequest Q() {
		StringBuilder sb = new StringBuilder();
		boolean appended = false;
		if (StringUtils.isNotBlank(status)) {
			sb.append("status").append("=").append(status);
			appended = true;
		}
		if (StringUtils.isNotBlank(title)) {
			if (appended) {
				sb.append("&");
			}
			sb.append("title").append("=").append(title);
			appended = true;
		}
		getQuery().setQueryString(sb.toString());
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}