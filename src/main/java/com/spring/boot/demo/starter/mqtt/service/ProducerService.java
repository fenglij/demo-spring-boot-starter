package com.spring.boot.demo.starter.mqtt.service;

import com.spring.boot.demo.starter.mqtt.factory.MqttClientFactory;
import com.spring.boot.demo.starter.mqtt.properties.MqttProperties;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fenglijian
 * @date 2022-10-11 19:29
 */
public class ProducerService {
    @Autowired
    private MqttClientFactory factory;
    @Autowired
    private MqttProperties mqttProperties;

    public void send(String payload) {
        this.send(mqttProperties.getProducerTopic(), payload);
    }

    public void send(String topic, String payload) {
        this.send(topic, mqttProperties.getProducerQos(), payload);
    }

    public void send(String topic, int qos, String payload) {
        this.send(topic, qos, mqttProperties.getProducerRetained(), payload);
    }

    public void send(String topic, int qos, boolean retained, String payload) {
        try {
            MqttClient mqttClient = factory.createMqttClient();
            factory.connect(mqttClient);
            mqttClient.publish(topic, payload.getBytes(), qos, retained);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
