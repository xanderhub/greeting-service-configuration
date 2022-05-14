package com.xanderhub.services.configuration;

import com.xanderhub.services.businesslogic.UserInfo;

public class SystemEnvironmentUserInfo implements UserInfo {

    private final String userName;
    private final String userLanguage;

    public SystemEnvironmentUserInfo() {
        userLanguage = System.getProperty("user.language");
        userName = System.getProperty("user.name");
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getUserLanguage() {
        return userLanguage;
    }
}
