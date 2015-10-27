package com.cdesigner.mgr.req;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * 
 * @version 1.0.0
 * @since 2015年7月4日 下午7:02:30
 */
public class NewsRequest {
	
	@NotNull
	private Integer type;// 1 行业, 2 地方

	@NotNull
	private String title;// 标题

	private String synopsis;// 摘要,显示列表使用

	private MultipartFile coverImg;// 封皮

	@NotNull
	private String article;// 内容

	private String status;// 状态 active,inactive,deleted

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public MultipartFile getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(MultipartFile coverImg) {
		this.coverImg = coverImg;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}