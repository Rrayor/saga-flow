package com.rrayor.sagaflow;

import org.testcontainers.containers.PostgreSQLContainer;

public class SagaFlowPostgresTestContainer extends PostgreSQLContainer<SagaFlowPostgresTestContainer> {
    private static final String IMAGE_VERSION = "postgres:11.1";
    private static SagaFlowPostgresTestContainer container;

    private SagaFlowPostgresTestContainer() {
        super(IMAGE_VERSION);
    }

    public static SagaFlowPostgresTestContainer getInstance() {
        if (container == null) {
            container = new SagaFlowPostgresTestContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());
        // System.setProperty("spring.liquibase.contexts", () -> "!prod");
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
