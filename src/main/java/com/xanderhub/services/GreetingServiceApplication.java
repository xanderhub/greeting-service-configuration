package com.xanderhub.services;

public class GreetingServiceApplication {

    public static void main(String[] args) {
        GreetingService greetingService = new GreetingService(DispatchBy.CONSOLE);
        greetingService.greet();
    }
}
