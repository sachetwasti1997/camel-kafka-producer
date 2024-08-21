package com.sachet.camel_microservice.routes;

import com.sachet.camel_microservice.kafka.admin.KafkaAdminClient;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class CreateTopicRoutes extends RouteBuilder {

    private final KafkaAdminClient kafkaAdminClient;

    public CreateTopicRoutes(KafkaAdminClient kafkaAdminClient) {
        this.kafkaAdminClient = kafkaAdminClient;
    }

    @Override
    public void configure() throws Exception {
        from("timer://runOnce?repeatCount=1&delay=60000")
                .bean(kafkaAdminClient, "createTopic");
    }
}
