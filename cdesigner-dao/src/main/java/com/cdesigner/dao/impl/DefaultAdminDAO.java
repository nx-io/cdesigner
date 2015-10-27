package com.cdesigner.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdesigner.dao.AdminDAO;
import com.cdesigner.domain.Admin;

@Repository
public class DefaultAdminDAO extends JpaBaseDAO<Admin, Long> implements AdminDAO {

	@Override
	public Admin queryAdmin(String loginName) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("loginName", loginName);
		return (Admin) createNamedQuery("Admin.queryAdmin", args).getSingleResult();
	}
}