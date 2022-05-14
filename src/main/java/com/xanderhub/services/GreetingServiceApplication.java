package com.xanderhub.services;

public class GreetingServiceApplication {

    public static void main(String[] args) {
        GreetingService greetingService = new GreetingService(DispatchTo.FILE);
        greetingService.greet();
    }
}
