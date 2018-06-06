package com.pgs.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    public static final int COUNT = 20;

    private CountDownLatch latch = new CountDownLatch(COUNT);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "dbserver1.inventory.customers")
    public void listen(String message) {
        LOGGER.info("received message='{}'", message);
    }
}
