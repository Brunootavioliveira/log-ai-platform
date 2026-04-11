package br.com.brunootavio.log_ingestion_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@EnableRabbit
@SpringBootApplication
public class LogIngestionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogIngestionApiApplication.class, args);
	}

}
