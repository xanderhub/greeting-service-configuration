package com.xanderhub.services.businesslogic;

public class GreetingService {

    private final GreetingGenerator greetingGenerator;
    private final UserInfoProvider userInfoProvider;
    private final GreetingDispatcher greetingDispatcher;


    public GreetingService(GreetingGenerator greetingGenerator, UserInfoProvider userInfoProvider, GreetingDispatcher greetingDispatcher) {
        this.greetingGenerator = greetingGenerator;
        this.userInfoProvider = userInfoProvider;
        this.greetingDispatcher = greetingDispatcher;
    }

    public void greet() {
        // Create greeting message based on user info
        String greeting = greetingGenerator.generate(userInfoProvider);

        // Dispatch greeting message
        greetingDispatcher.dispatch(greeting);
    }
}
