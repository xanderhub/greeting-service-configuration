package com.xanderhub.services;

import com.xanderhub.services.businesslogic.GreetingService;
import com.xanderhub.services.businesslogic.UserInfo;
import com.xanderhub.services.configuration.ConfigurationFileUserInfo;
import com.xanderhub.services.configuration.ConsoleGreetingDispatcher;
import com.xanderhub.services.configuration.FileGreetingDispatcher;
import com.xanderhub.services.configuration.SystemEnvironmentUserInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Properties;

public class GreetingServiceApplication {

    public static void main(String[] args) {

        Map<String, String> translatedGreetings = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("en", "Hello"),
                new AbstractMap.SimpleEntry<>("it", "Ciao"),
                new AbstractMap.SimpleEntry<>("he", "שלום"));

        UserInfo userInfo;
        Properties applicationProperties = loadApplicationProperties();

        if (applicationProperties == null
                || applicationProperties.getProperty("app.userinfo.username") == null
                || applicationProperties.getProperty("app.userinfo.userlanguage") == null) {

            userInfo = new SystemEnvironmentUserInfo();
        } else {
            userInfo = new ConfigurationFileUserInfo(applicationProperties);
        }

        GreetingService greetingService = new GreetingService (translatedGreetings, userInfo, new ConsoleGreetingDispatcher());
        greetingService.greet();
    }

    private static Properties loadApplicationProperties() {
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
