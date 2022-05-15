package com.xanderhub.services.impl.greetinggenerators;

import com.xanderhub.services.businesslogic.GreetingGenerator;
import com.xanderhub.services.businesslogic.UserInfoProvider;

import java.util.Map;

public class InternationalGreetingGenerator implements GreetingGenerator {

    private final Map<String, String> translatedGreetings;

    public InternationalGreetingGenerator(Map<String, String> translatedGreetings) {
        this.translatedGreetings = translatedGreetings;
    }

    @Override
    public String generate(UserInfoProvider userInfoProvider) {
        return translatedGreetings.getOrDefault(userInfoProvider.getUserLanguage(), "Hello") + " " + userInfoProvider.getUserName();
    }
}
