package com.xanderhub.services.impl.dispatchers;

import com.xanderhub.services.businesslogic.GreetingDispatcher;

public class ConsoleGreetingDispatcher implements GreetingDispatcher {
    @Override
    public void dispatch(String greeting) {
        System.out.println(greeting);
    }
}
