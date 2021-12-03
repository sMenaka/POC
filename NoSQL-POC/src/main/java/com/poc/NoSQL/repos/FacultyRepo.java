package com.poc.NoSQL.repos;

import com.poc.NoSQL.models.Faculty;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface FacultyRepo extends MongoRepository<Faculty, UUID> {
}
