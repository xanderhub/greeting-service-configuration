package com.xanderhub.services.configuration;

import com.xanderhub.services.businesslogic.GreetingDispatcher;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileGreetingDispatcher implements GreetingDispatcher {

    @SneakyThrows
    @Override
    public void dispatch(String greeting) {
        Files.write(Paths.get("greeting.txt"), greeting.getBytes());
    }
}
