package com.xanderhub.services.configuration;

import com.xanderhub.services.businesslogic.UserInfo;

public class SystemEnvironmentUserInfo implements UserInfo {

    @Override
    public String getUserName() {
        return System.getProperty("user.language");
    }

    @Override
    public String getUserLanguage() {
        return System.getProperty("user.name");
    }
}
