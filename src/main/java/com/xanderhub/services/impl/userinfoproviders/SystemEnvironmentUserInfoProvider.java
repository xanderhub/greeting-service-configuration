package com.xanderhub.services.impl.userinfoproviders;

import com.xanderhub.services.businesslogic.UserInfoProvider;

public class SystemEnvironmentUserInfoProvider implements UserInfoProvider {

    @Override
    public String getUserName() {
        return System.getProperty("user.name");
    }

    @Override
    public String getUserLanguage() {
        return System.getProperty("user.language");
    }
}
