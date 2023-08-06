package com.rrayor.sagaflow.test.internal.repository;

import com.rrayor.sagaflow.test.internal.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Long> {}
