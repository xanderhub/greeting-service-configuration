package com.xanderhub.services.impl.userinfoproviders;

import com.xanderhub.services.businesslogic.UserInfoProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Log4j2
@Component
@ConditionalOnProperty({"app.userinfo.username", "app.userinfo.userlanguage"})
@ConfigurationProperties("app.userinfo")
public class ConfigurationFileUserInfoProvider implements UserInfoProvider {

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public void setSecured(Boolean secured) {
        this.secured = secured;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    String userName;

    String userLanguage;

    Boolean secured;

    List<String> data;

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getUserLanguage() {
        return userLanguage;
    }

    @PostConstruct
    public void init() {
        log.info("ConfigurationFileUserInfoProvider - BEAN CREATED with properties: " + userName + " " + userLanguage +" secured: " + secured + " data: " + data);
    }
}
