package com.example.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@RestController
public class ProducerApplication {
	private final static Logger LOG = LogManager.getLogger(ProducerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	private final static String URL = "http://172.17.0.6:8081/sendTimestamp";

	private String message = "Sending ";

	@Scheduled(fixedDelay = 1000)
	public void send(){
//		LOG.info("Sending");
//		System.out.println(message + System.currentTimeMillis());

		//ResponseEntity<String> message = null;

		try {

			message = String.valueOf(System.currentTimeMillis());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

			final HttpEntity<String> messageHttpEntity = new HttpEntity<>(message, headers);

			restTemplate.exchange(URL, HttpMethod.POST, messageHttpEntity, String.class);
			LOG.info("Sent message: {}", message);

		} catch (Exception e){
			LOG.error("Error sending message due to {} with stacktrace {}", e.getMessage(), e);
		}

	}
}
