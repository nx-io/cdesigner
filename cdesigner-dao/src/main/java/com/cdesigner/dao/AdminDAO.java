package com.cdesigner.dao;

import com.cdesigner.domain.Admin;

public interface AdminDAO extends BaseDAO<Admin, Long> {
	Admin queryAdmin(String loginName);
}