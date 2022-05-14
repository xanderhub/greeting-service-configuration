package com.xanderhub.services;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Map;

public class GreetingService {

    private final Map<String, String> translatedGreetings;
    private final DispatchBy dispatchBy;

    public GreetingService(DispatchBy dispatchBy) {
        this.dispatchBy = dispatchBy;
        this.translatedGreetings = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("en", "Hello"),
                new AbstractMap.SimpleEntry<>("it", "Ciao"),
                new AbstractMap.SimpleEntry<>("he", "שלום"));
    }

    public void greet() {
        String translatedGreeting = translatedGreetings.getOrDefault(System.getProperty("user.language"), "Hello");
        String userName = System.getProperty("user.name");

        if(dispatchBy.equals(DispatchBy.FILE))
            dispatchByFile(translatedGreeting +" "+ userName);
        else
            dispatchByConsole(translatedGreeting +" "+ userName);
    }

    private void dispatchByConsole(String greeting) {
        System.out.println(greeting);
    }

    @SneakyThrows
    private void dispatchByFile(String greeting) {
        Files.write(Paths.get("greeting.txt"), greeting.getBytes());
    }
}
