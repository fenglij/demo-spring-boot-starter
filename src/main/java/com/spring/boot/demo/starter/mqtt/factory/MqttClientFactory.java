package com.spring.boot.demo.starter.mqtt.factory;

import com.spring.boot.demo.starter.mqtt.properties.MqttProperties;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 客户端工厂
 */
@Component
public class MqttClientFactory {

    @Autowired
    private MqttProperties mqttProperties;

    public MqttClient createMqttClient() throws MqttException {
        Random random = new Random();
        int r = random.nextInt(10);
        MqttClientPersistence persistence = this.clientPersistence();
        MqttClient mqttClient = new MqttClient(mqttProperties.getBrokerUri(), mqttProperties.getClientId() + r, persistence);
        return mqttClient;
    }

    private MqttConnectOptions connectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(mqttProperties.getUsername());
        options.setPassword(mqttProperties.getPassword().toCharArray());
        options.setCleanSession(true);
        options.setAutomaticReconnect(true);
        options.setConnectionTimeout(mqttProperties.getClientConnectionTimeout());
        options.setKeepAliveInterval(mqttProperties.getClientKeepAliveInterval());
        return options;
    }

    private MqttClientPersistence clientPersistence() {
        return new MemoryPersistence();
    }

    public void connect(MqttClient mqttClient) throws MqttException {
        mqttClient.connect(this.connectOptions());
    }
}
