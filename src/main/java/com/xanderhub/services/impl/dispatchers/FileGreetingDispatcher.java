package com.xanderhub.services.impl.dispatchers;

import com.xanderhub.services.businesslogic.GreetingDispatcher;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;

@Log4j2
@Component
@ConditionalOnProperty(name="app.greeting.dispatcher", havingValue = "FileGreetingDispatcher")
public class FileGreetingDispatcher implements GreetingDispatcher {

    @SneakyThrows
    @Override
    public void dispatch(String greeting) {
        Files.write(Paths.get("greeting.txt"), greeting.getBytes());
    }

    @PostConstruct
    public void init() {
        log.info("FileGreetingDispatcher - BEAN CREATED");
    }
}
