package com.example.consumer.service;

import com.example.consumer.config.ActiveMQConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQListener {
    private static final Logger LOG = LogManager.getLogger(ActiveMQListener.class);

    private JmsTemplate jmsTemplate;

    private ActiveMQConfig activeMQConfiguration;

    @Autowired
    public ActiveMQListener(JmsTemplate jmsTemplate, ActiveMQConfig activeMQConfiguration){
        this.jmsTemplate = jmsTemplate;
        this.activeMQConfiguration = activeMQConfiguration;
    }

    @JmsListener(destination = ActiveMQConfig.MESSAGE_QUEUE )
    public void receiveMessage(String message){
        LOG.info("In receiveMessage");

        System.out.println("ActiveMQ ->" + message);
    }
}
