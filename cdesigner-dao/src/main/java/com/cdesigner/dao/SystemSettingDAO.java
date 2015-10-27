package com.cdesigner.dao;

import java.util.List;

import com.cdesigner.domain.SystemSetting;

public interface SystemSettingDAO extends BaseDAO<SystemSetting, Long> {

    List<SystemSetting> getSettings(String group);
}
