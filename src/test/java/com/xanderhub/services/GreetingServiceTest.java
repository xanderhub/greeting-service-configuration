package com.xanderhub.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void greet() {
        GreetingService greetingService = new GreetingService(DispatchBy.CONSOLE);
        greetingService.greet();

        assertTrue(outContent.toString().contains("Hello"));
    }
}
