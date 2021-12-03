package com.poc.NoSQL.repos;

import com.poc.NoSQL.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends MongoRepository<User, UUID> {

}
