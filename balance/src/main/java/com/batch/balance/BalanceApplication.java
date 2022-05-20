package com.batch.balance;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableBatchProcessing
@SpringBootApplication
@EnableScheduling
public class BalanceApplication {
	//https://github.com/spring-projects/spring-batch
	//https://docs.spring.io/spring-batch/docs/current/api/index.html?org/springframework/batch/core/configuration/annotation/JobBuilderFactory.html

	public static void main(String[] args) {
		SpringApplication.run(BalanceApplication.class, args);
	}

}
