package com.example.mongoLb3.repository;

import com.example.mongoLb3.model.TestAnimal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMongoRepository extends MongoRepository<TestAnimal, String> {



}
