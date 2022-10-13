package com.spring.boot.demo.starter.mqtt.service;

import com.spring.boot.demo.starter.mqtt.factory.MqttClientFactory;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通过 MqttConfiguration 暴露自定义订阅方法
 * @author fenglijian
 * @date 2022-10-12 10:22
 */
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private MqttClientFactory factory;

    public void subscribe(String topic, IMqttMessageListener listener) {
        try {
            MqttClient mqttClient = factory.createMqttClient();
            factory.connect(mqttClient);
            mqttClient.subscribe(topic, listener);
        } catch (MqttException e) {
            logger.error("订阅主题失败，主题: {}", topic, e);
        }
    }
}
