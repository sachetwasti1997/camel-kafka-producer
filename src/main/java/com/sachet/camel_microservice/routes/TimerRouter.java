package com.sachet.camel_microservice.routes;

import com.sachet.camel_microservice.utility.LoggingComponent;
import com.sachet.camel_microservice.utility.LoggingProcessor;
import com.sachet.camel_microservice.utility.RandomDateUtility;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

//@Component
public class TimerRouter extends RouteBuilder {

    private final RandomDateUtility randomDateUtility;
    private final LoggingComponent loggingComponent;

    public TimerRouter(RandomDateUtility randomDateUtility, LoggingComponent loggingComponent) {
        this.randomDateUtility = randomDateUtility;
        this.loggingComponent = loggingComponent;
    }

    @Override
    public void configure() throws Exception {
        // listen to a something like timer or queue

        // create a timer endpoint
        from("timer:router-timer")
                .log("${body}")
                .transform().constant("This is a constant message")
                .log("${body}")
                .bean(randomDateUtility, "nextDate")
                .bean(loggingComponent) // processing step after transformation step
                .process(new LoggingProcessor()) // processing
                // operations that can be performed
                // 1. processing
                // 2. transformation
                .to("log:timer-log");

        // do some transformations
        // save to database
    }
}
