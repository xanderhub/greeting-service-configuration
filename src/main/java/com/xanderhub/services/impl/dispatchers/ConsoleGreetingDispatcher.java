package com.xanderhub.services.impl.dispatchers;

import com.xanderhub.services.businesslogic.GreetingDispatcher;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component
@ConditionalOnProperty(name="app.greeting.dispatcher", havingValue = "ConsoleGreetingDispatcher")
public class ConsoleGreetingDispatcher implements GreetingDispatcher {
    @Override
    public void dispatch(String greeting) { System.out.println(greeting); }

    @PostConstruct
    public void init() {
        log.info("ConsoleGreetingDispatcher - BEAN CREATED");
    }
}
