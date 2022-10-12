package com.spring.boot.demo.starter.mqtt.listener;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 获取监听器类，订阅的时候需要使用到
 * @author fenglijian
 * @date 2022-10-12 17:14
 */
@Component
public class MqttMessageListenerHelper {
    @Autowired
    private ApplicationContext context;

    public Map<String, IMqttMessageListener> getListenerBean() {
        Map<String, IMqttMessageListener> listenerMap = context.getBeansOfType(IMqttMessageListener.class);
        return listenerMap;
    }
}
