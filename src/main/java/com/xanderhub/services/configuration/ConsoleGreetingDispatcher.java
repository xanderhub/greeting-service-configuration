package com.xanderhub.services.configuration;

import com.xanderhub.services.businesslogic.GreetingDispatcher;

public class ConsoleGreetingDispatcher implements GreetingDispatcher {
    @Override
    public void dispatch(String greeting) {
        System.out.println(greeting);
    }
}
