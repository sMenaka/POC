package com.poc.NoSQL.repos;

import com.poc.NoSQL.models.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DepartmentRepo extends MongoRepository<Department, UUID> {
}
