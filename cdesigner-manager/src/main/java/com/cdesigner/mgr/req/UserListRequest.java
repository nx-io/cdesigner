package com.cdesigner.mgr.req;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 * 
 * @version 1.0.0
 * @since 2015年7月4日 下午7:02:30
 */
public class UserListRequest extends PageRequest {

	private Long id;

	private String name;

	private String email;

	private String mobile;
	
	private Long roleId = 0L;// 1:创业者, 2:投资人, 3:导师

	@Override
	protected UserListRequest Q() {
		StringBuilder sb = new StringBuilder();
		boolean appended = false;
		if (StringUtils.isNotBlank(name)) {
			sb.append("name").append("=").append(name);
			appended = true;
		}
		if (StringUtils.isNotBlank(email)) {
			if (appended) {
				sb.append("&");
			}
			sb.append("email").append("=").append(email);
			appended = true;
		}
        if (roleId != null && roleId > 0L) {
            if (appended) {
                sb.append("&");
            }
            sb.append("roleId").append("=").append(roleId);
            appended = true;
        }
		if (id != null && id > 0L) {
			if (appended) {
				sb.append("&");
			}
			sb.append("id").append("=").append(id);
			appended = true;
		}
		if (StringUtils.isNotBlank(mobile)) {
			if (appended) {
				sb.append("&");
			}
			sb.append("mobile").append("=").append(mobile);
			appended = true;
		}
		getQuery().setQueryString(sb.toString());
		return this;
	}

	public Long getRoleId() {
	    if (roleId == null || roleId <= 0L) {
	        roleId = 0L;
	    }
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}