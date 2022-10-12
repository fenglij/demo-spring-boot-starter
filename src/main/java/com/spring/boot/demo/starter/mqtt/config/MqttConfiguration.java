package com.spring.boot.demo.starter.mqtt.config;

import com.spring.boot.demo.starter.mqtt.properties.MqttProperties;
import com.spring.boot.demo.starter.mqtt.service.ConsumerService;
import com.spring.boot.demo.starter.mqtt.service.ProducerService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fenglijian
 * @date 2022-10-11 19:45
 */
@Configuration
@ConditionalOnProperty(prefix = "mqtt", name = "switch", havingValue = "true")
public class MqttConfiguration {

    @Bean(name = "consumerService")
    public ConsumerService consumerService() {
        return new ConsumerService();
    }

    @Bean(name = "producerService")
    public ProducerService producerService() {
        return new ProducerService();
    }
}
