package com.spring.boot.demo.starter.mqtt.config;

import com.spring.boot.demo.starter.mqtt.factory.MqttClientFactory;
import com.spring.boot.demo.starter.mqtt.listener.MqttMessageListenerHelper;
import com.spring.boot.demo.starter.mqtt.properties.MqttProperties;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 容器启动的时候主动发起订阅
 * @author fenglijian
 * @date 2022-10-12 16:47
 */
@Order(-1)
@Component
public class ConsumerConfiguration implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerConfiguration.class);

    @Autowired
    private MqttClientFactory factory;
    @Autowired
    private MqttProperties mqttProperties;
    @Autowired
    private MqttMessageListenerHelper mqttMessageListenerHelper;

    @Override
    public void run(String... args) throws Exception {
        logger.info("启动自动订阅开始......");
        this.subscribe(mqttProperties.getProducerTopic());
    }

    /**
     * 订阅主题
     * @param topic
     * @throws MqttException
     */
    private void subscribe(String topic) throws MqttException {
        Map<String, IMqttMessageListener> listenerMap = mqttMessageListenerHelper.getListenerBean();
        if (listenerMap.isEmpty()) {
            return;
        }
        listenerMap.forEach((k, v) -> {
            try {
                MqttClient mqttClient = factory.createMqttClient();
                factory.connect(mqttClient);
                mqttClient.subscribe(topic, v);
            } catch (MqttException e) {
                logger.error("订阅主题失败，主题: {}", topic);
            }
        });
    }
}
