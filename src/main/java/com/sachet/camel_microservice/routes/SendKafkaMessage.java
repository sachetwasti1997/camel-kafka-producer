package com.sachet.camel_microservice.routes;

import com.sachet.camel_microservice.utility.RandomDateUtility;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SendKafkaMessage extends RouteBuilder {

    private final RandomDateUtility randomDateUtility;

    public SendKafkaMessage(RandomDateUtility randomDateUtility) {
        this.randomDateUtility = randomDateUtility;
    }

    @Override
    public void configure() throws Exception {
        from("timer://test-kafka?period=10000")
//                .setBody(simple("This message is being sent at the time "+ LocalDateTime.now()))
                .bean(randomDateUtility, "nextDate")
                .to("kafka:camel-topic");
    }
}
