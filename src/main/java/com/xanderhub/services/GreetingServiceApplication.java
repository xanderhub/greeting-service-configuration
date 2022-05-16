package com.xanderhub.services;

import com.xanderhub.services.businesslogic.GreetingService;
import com.xanderhub.services.impl.greetinggenerators.InternationalGreetingGenerator;
import com.xanderhub.services.businesslogic.UserInfoProvider;
import com.xanderhub.services.impl.userinfoproviders.ConfigurationFileUserInfoProvider;
import com.xanderhub.services.impl.dispatchers.ConsoleGreetingDispatcher;
import com.xanderhub.services.impl.userinfoproviders.SystemEnvironmentUserInfoProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Properties;

public class GreetingServiceApplication {

    public static void main(String[] args) {

        Map<String, String> translatedGreetings = Map.of("en", "Hello","it", "Ciao","he", "שלום");

        UserInfoProvider userInfoProvider;
        Properties applicationProperties = loadApplicationProperties();

        if (applicationProperties == null
                || applicationProperties.getProperty("app.userinfo.username") == null
                || applicationProperties.getProperty("app.userinfo.userlanguage") == null) {

            userInfoProvider = new SystemEnvironmentUserInfoProvider();
        } else {
            userInfoProvider = new ConfigurationFileUserInfoProvider(applicationProperties);
        }

        GreetingService greetingService = new GreetingService(
                new InternationalGreetingGenerator(translatedGreetings),
                userInfoProvider,
                new ConsoleGreetingDispatcher());

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
