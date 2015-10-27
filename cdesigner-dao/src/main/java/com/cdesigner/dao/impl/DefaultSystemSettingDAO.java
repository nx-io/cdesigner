package com.cdesigner.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cdesigner.dao.SystemSettingDAO;
import com.cdesigner.domain.SystemSetting;

@Repository
public class DefaultSystemSettingDAO extends JpaBaseDAO<SystemSetting, Long> implements SystemSettingDAO {

    @Override
    public List<SystemSetting> getSettings(String group) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("group", group);

        return queryByNamedQuery("SystemSetting.getByGroup", parameters);
    }

}
