package com.xanderhub.services;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Properties;

public class GreetingService {

    private final Properties applicationProperties;
    private final Map<String, String> translatedGreetings;
    private final DispatchTo dispatchTo;

    public GreetingService(DispatchTo dispatchTo) {
        this.dispatchTo = dispatchTo;
        this.translatedGreetings = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("en", "Hello"),
                new AbstractMap.SimpleEntry<>("it", "Ciao"),
                new AbstractMap.SimpleEntry<>("he", "שלום"));

        this.applicationProperties = loadApplicationProperties();
    }

    public void greet() {
        String translatedGreeting;
        String userName;

        // resolve user information (language & username)
        if (applicationProperties == null
                || applicationProperties.getProperty("app.userinfo.username") == null
                || applicationProperties.getProperty("app.userinfo.userlanguage") == null) {

            translatedGreeting = translatedGreetings.getOrDefault(System.getProperty("user.language"), "Hello");
            userName = System.getProperty("user.name");
        }

        else {
            translatedGreeting = translatedGreetings.getOrDefault(applicationProperties.getProperty("app.userinfo.userlanguage"), "Hello");
            userName = applicationProperties.getProperty("app.userinfo.username");
        }

        // dispatch greeting to console or file
        if(dispatchTo.equals(DispatchTo.FILE))
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

    private Properties loadApplicationProperties(){
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            // load a properties file
            properties.load(input);
            return properties;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
