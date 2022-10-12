package com.spring.boot.demo.starter.mqtt.listener;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息回调 抽象类
 * 开放receiveMessage抽象方法提供给业务方自定义实现，处理逻辑
 */
public abstract class AbstractMqttMessageListener implements IMqttMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(AbstractMqttMessageListener.class);

    public abstract boolean receiveMessage(String topic, MqttMessage message);

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        logger.info("接收到消息，主题:{}，消息: {}", topic, mqttMessage);
        this.receiveMessage(topic, mqttMessage);
    }
}
