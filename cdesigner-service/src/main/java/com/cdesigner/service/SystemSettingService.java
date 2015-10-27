package com.cdesigner.service;

import java.util.Map;

public interface SystemSettingService {
    Map<String, String> getSettings(String settingGroup);
}
