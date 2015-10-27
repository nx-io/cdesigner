package com.cdesigner.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdesigner.dao.SystemSettingDAO;
import com.cdesigner.domain.SystemSetting;
import com.cdesigner.service.SystemSettingService;

@Service
public class SystemSettingServiceImpl extends BaseService implements SystemSettingService {

    @Resource
    private SystemSettingDAO systemSettingDAO;

    @Override
    public Map<String, String> getSettings(String settingGroup) {
        Map<String, String> systemconfig = new HashMap<String, String>();

        List<SystemSetting> settings = systemSettingDAO.getSettings(settingGroup);
        for (SystemSetting setting : settings) {
            systemconfig.put(setting.getKey(), setting.getValue());
        }

        return systemconfig;
    }

}
