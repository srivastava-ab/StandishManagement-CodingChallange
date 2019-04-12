package com.example.abhinav.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abhinav.models.Client;
import com.example.abhinav.models.TestClient;

public interface TestRepository extends MongoRepository<TestClient, String>{


}
