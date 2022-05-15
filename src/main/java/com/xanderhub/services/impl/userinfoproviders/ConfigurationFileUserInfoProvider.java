package com.xanderhub.services.impl.userinfoproviders;

import com.xanderhub.services.businesslogic.UserInfoProvider;

import java.util.Properties;

public class ConfigurationFileUserInfoProvider implements UserInfoProvider {

    private final Properties applicationProperties;

    public ConfigurationFileUserInfoProvider(Properties applicationProperties) {
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
