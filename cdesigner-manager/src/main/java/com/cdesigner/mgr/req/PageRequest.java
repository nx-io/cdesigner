package com.cdesigner.mgr.req;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * 
 * @version 1.0.0
 * @since 2015年7月4日 下午7:02:30
 */
public abstract class PageRequest extends ViewRequest {

	private PageQuery query;

	private int page = 1;

	private int limit;
    
	public PageRequest init() {
		if (limit <= 0) {
			limit = PageQuery.DEFAULT_PAGE_SIZE;
		}
		query = new PageQuery(limit, page);
		Q();
		return this;
	}

	protected abstract PageRequest Q();

	public PageQuery getQuery() {
		return query;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

    public void setCount(int count) {
        this.query.setCount(count);
        
    }
}