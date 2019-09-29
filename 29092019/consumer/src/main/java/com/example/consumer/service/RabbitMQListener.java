//package com.example.consumer.service;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RabbitMQListener {
//    private static final Logger LOG = LogManager.getLogger(RabbitMQListener.class);
//
//    @RabbitListener(containerFactory = "rabbitListenerContainerFactory")
//    public void receiveMessage(String message){
//        LOG.info("In receiveMessage");
//
//        System.out.println("RabbitMQ -> " + message);
//    }
//}
