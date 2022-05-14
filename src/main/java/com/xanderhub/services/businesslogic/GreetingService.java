package com.xanderhub.services.businesslogic;

import java.util.Map;

public class GreetingService {

    private final Map<String, String> translatedGreetings;
    private final GreetingDispatcher greetingDispatcher;
    private final UserInfo userInfo;

    public GreetingService(Map<String, String> translatedGreetings, UserInfo userInfo, GreetingDispatcher greetingDispatcher) {
        this.translatedGreetings = translatedGreetings;
        this.userInfo = userInfo;
        this.greetingDispatcher = greetingDispatcher;
    }

    public void greet() {
        // Create greeting message based on user info
        String translatedGreeting = translatedGreetings.getOrDefault(userInfo.getUserLanguage(), "Hello");
        // Dispatch greeting message
        greetingDispatcher.dispatch(translatedGreeting + " " + userInfo.getUserName());
    }
}
