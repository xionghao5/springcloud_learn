package com.gua.ka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.io.IOException;

@SpringBootTest(classes = KafkaServerTest.class)
@EmbeddedKafka(count = 4, ports = {9092, 9093, 9094, 9095})
public class KafkaServerTest {
    @Test
    public void contextLoads() throws IOException {
        System.in.read();
    }
}