package com.rrayor.sagaflowbackend.test.internal.repository;

import com.rrayor.sagaflowbackend.test.internal.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity, Long> {}
