//package com.example.consumer.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class RabbitMQConfig {
//
//    public final static String EXCHANGE = "message.exchange";
//    public final static String QUEUE = "message.queue";
//    public final static String ROUTING_KEY = "message";
//
//    @Bean
//    DirectExchange messageExchange(){return new DirectExchange(EXCHANGE);}
//
//    @Bean
//    Queue messageQueue(){
//        return QueueBuilder.durable(QUEUE)
//                .build();
//    }
//
//    @Bean
//    Binding binding(){
//        return BindingBuilder.bind(messageQueue()).to(messageExchange()).with(ROUTING_KEY);
//    }
//
//    @Bean
//    public CachingConnectionFactory getConnectionFactory() throws IOException {
//        com.rabbitmq.client.ConnectionFactory factory = new com.rabbitmq.client.ConnectionFactory();
//
//        factory.setHost("172.30.0.2");
//        factory.setPort(5672);
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//
//        factory.setAutomaticRecoveryEnabled(true);
//
//        return new CachingConnectionFactory(factory);
//    }
//
//    @Bean
//    @Qualifier("rabbitListenerContainerFactory")
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() throws IOException{
//
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(getConnectionFactory());
//
//        //factory.setMessageConverter(new JsonConverter());
//        factory.setDefaultRequeueRejected(false);
//        //factory.setAdviceChain(rabbitListenerAroundAdvice());
//
//        return factory;
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//
//        //rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//        return rabbitTemplate;
//    }
//
//}
