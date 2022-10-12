package com.spring.boot.demo.starter.mqtt.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fenglijian
 * @date 2022-10-11 17:49
 */
@Configuration
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {
    private String brokerUri;
    private String username;
    private String password;

    private String clientId;
    private Integer clientKeepAliveInterval;
    private Integer clientConnectionTimeout;

    private Integer producerQos;
    private Boolean producerRetained;
    private String producerTopic;

    public String getBrokerUri() {
        return brokerUri;
    }

    public void setBrokerUri(String brokerUri) {
        this.brokerUri = brokerUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getClientKeepAliveInterval() {
        return clientKeepAliveInterval;
    }

    public void setClientKeepAliveInterval(Integer clientKeepAliveInterval) {
        this.clientKeepAliveInterval = clientKeepAliveInterval;
    }

    public Integer getClientConnectionTimeout() {
        return clientConnectionTimeout;
    }

    public void setClientConnectionTimeout(Integer clientConnectionTimeout) {
        this.clientConnectionTimeout = clientConnectionTimeout;
    }

    public Integer getProducerQos() {
        return producerQos;
    }

    public void setProducerQos(Integer producerQos) {
        this.producerQos = producerQos;
    }

    public Boolean getProducerRetained() {
        return producerRetained;
    }

    public void setProducerRetained(Boolean producerRetained) {
        this.producerRetained = producerRetained;
    }

    public String getProducerTopic() {
        return producerTopic;
    }

    public void setProducerTopic(String producerTopic) {
        this.producerTopic = producerTopic;
    }
}
