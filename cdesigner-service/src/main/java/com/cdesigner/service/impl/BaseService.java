package com.cdesigner.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdesigner.util.IpUtil;

public abstract class BaseService {
    
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    protected long getIp() {
        String ip = IpUtil.getIpAddr(request);
        return IpUtil.ip2Long(ip);
    }
}
