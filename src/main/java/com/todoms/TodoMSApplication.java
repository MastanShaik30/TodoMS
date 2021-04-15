package com.todoms;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableEurekaClient
public class TodoMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoMSApplication.class, args);
	}
	
	@Bean
	@Profile("!test & !integration")
	public CommandLineRunner run(ApplicationContext appContext) {
		return args -> {
			String[] beans = appContext.getBeanDefinitionNames();
			Arrays.stream(beans).sorted().forEach(System.out::println);
		};
	}

}
