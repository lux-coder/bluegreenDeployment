package com.example.consumer.controller;

//import com.example.consumer.config.RabbitMQConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
public class ConsumerController {
    private final static Logger LOG = LogManager.getLogger(ConsumerController.class);

    private final JmsTemplate jmsTemplate;

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

//    @Autowired
//    private RabbitMQConfig rabbitMQConfig;

    @Autowired
    public ConsumerController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/sendTimestamp")
    public void printMessageViaActive(@RequestBody String message){
        LOG.info("In printMessageViaActive");
        LOG.info("Message {}", message);

        try {
            jmsTemplate.convertAndSend("message.queue", message);
        } catch (Exception e){
            LOG.error("Exception while sending to queue due to {}, with stacktrace: {}", e, e.getMessage());
        }
    }
//
//    @PostMapping("/sendTimestamp")
//    public void printMessageViaRabbit(@RequestBody String message){
//        LOG.info("In printMessageViaRabbit");
//        LOG.info("Message {}", message);
//
//        try {
//
//            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
//
//        } catch (Exception e){
//            LOG.error("Exception while sending to queue due to {}, with stacktrace: {}", e, e.getMessage());
//        }
//    }
}
