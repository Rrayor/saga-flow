package com.rrayor.sagaflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestSagaFlowApplication {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return SagaFlowPostgresTestContainer.getInstance();
	}

	public static void main(String[] args) {
		SpringApplication.from(SagaFlowApplication::main).with(TestSagaFlowApplication.class).run(args);
	}

}
