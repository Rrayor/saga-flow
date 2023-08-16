package com.rrayor.sagaflow.core;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AuditEntity {

    @Column(name = "created_at", nullable = false)
    protected OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at", nullable = false)
    protected OffsetDateTime updatedAt = OffsetDateTime.now();

    // To make a proper relation we would need to depend on the auth module which would create
    // a circular dependency. Also, if we move to microservices in the future, users will be stored
    // in a separate service.
    // TODO: Should have a system user with the ID -1
    @Column(name = "created_by", nullable = false)
    protected Long createdBy = -1L;
}
