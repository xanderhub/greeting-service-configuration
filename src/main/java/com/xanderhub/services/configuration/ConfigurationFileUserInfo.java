package com.xanderhub.services.configuration;

import com.xanderhub.services.businesslogic.UserInfo;

import java.util.Properties;

public class ConfigurationFileUserInfo implements UserInfo {

    private final Properties applicationProperties;

    public ConfigurationFileUserInfo(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public String getUserName() {
        return applicationProperties.getProperty("app.userinfo.username");
    }

    @Override
    public String getUserLanguage() {
        return applicationProperties.getProperty("app.userinfo.userlanguage");
    }


}
