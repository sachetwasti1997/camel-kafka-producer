package com.sachet.camel_microservice.utility;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("The message Received is from Processor: {}", exchange.getMessage().getBody());
    }
}
