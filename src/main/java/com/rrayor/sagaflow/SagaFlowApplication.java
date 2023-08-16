package com.rrayor.sagaflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic(sharedModules = "core")
@SpringBootApplication
public class SagaFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SagaFlowApplication.class, args);
	}

}
