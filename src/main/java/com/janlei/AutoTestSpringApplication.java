package com.janlei;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoTestSpringApplication {

	@Value("${spring.application.name}")
	private  String application;

	public static void main(String[] args) {
		SpringApplication.run(AutoTestSpringApplication.class, args);
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer() {
		return (registry) -> registry.config().commonTags("application", application);
	}
}
