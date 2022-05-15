package com.xanderhub.services.impl.userinfoproviders;

import com.xanderhub.services.businesslogic.UserInfoProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component
@ConditionalOnMissingBean(ConfigurationFileUserInfoProvider.class)
public class SystemEnvironmentUserInfoProvider implements UserInfoProvider {

    @Override
    public String getUserName() {
        return System.getProperty("user.name");
    }

    @Override
    public String getUserLanguage() {
        return System.getProperty("user.language");
    }

    @PostConstruct
    public void init() {
        log.info("SystemEnvironmentUserInfoProvider - BEAN CREATED");
    }
}
