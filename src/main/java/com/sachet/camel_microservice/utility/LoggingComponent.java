package com.sachet.camel_microservice.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingComponent.class);
    public void logBody(String body) {
        LOGGER.info("Message received is: {}",body);
    }
}
