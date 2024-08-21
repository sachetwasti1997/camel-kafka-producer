package com.sachet.camel_microservice.utility;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.kafka.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        LOGGER.info("Message Received: {}, partition: {}, topic-name: {}, offset: {}",
                    message.getBody(),
                    message.getHeader(KafkaConstants.PARTITION),
                    message.getHeader(KafkaConstants.TOPIC),
                    message.getHeader(KafkaConstants.OFFSET)
                );
    }
}
