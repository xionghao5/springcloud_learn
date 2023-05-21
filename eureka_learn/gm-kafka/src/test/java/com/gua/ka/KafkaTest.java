package com.gua.ka;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

@SpringBootTest
@EmbeddedKafka
public class KafkaTest {

    private static final Logger log = LoggerFactory.getLogger(KafkaTest.class);

    @Autowired
    EmbeddedKafkaBroker broker;

    @Autowired
    KafkaTemplate<String, String> template;

    @Test
    void kafka() throws InterruptedException, ExecutionException {
        log.info("start send");

        ListenableFuture<SendResult<String, String>> future = template
                .send("topic1", "time: " + System.currentTimeMillis());
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onFailure(Throwable throwable) {
                log.error("onFailure", throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("onSuccess {}", stringStringSendResult);
            }
        });

        log.info("result: {}", future.get());

    }

}
