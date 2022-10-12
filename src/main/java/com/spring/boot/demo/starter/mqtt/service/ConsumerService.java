package com.spring.boot.demo.starter.mqtt.service;

import com.spring.boot.demo.starter.mqtt.factory.MqttClientFactory;
import com.spring.boot.demo.starter.mqtt.listener.MqttMessageListener;
import com.spring.boot.demo.starter.mqtt.properties.MqttProperties;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fenglijian
 * @date 2022-10-12 10:22
 */
public class ConsumerService {
    @Autowired
    private MqttClientFactory factory;
    @Autowired
    private MqttProperties mqttProperties;

    public void subscribe() throws MqttException {
        this.subscribe(mqttProperties.getProducerTopic());
    }

    public void subscribe(String topic) throws MqttException {
        MqttClient mqttClient = factory.createMqttClient();
        factory.connect(mqttClient);
        mqttClient.subscribe(topic, new MqttMessageListener());
    }
}
