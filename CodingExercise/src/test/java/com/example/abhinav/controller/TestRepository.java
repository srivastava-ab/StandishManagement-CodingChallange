package com.example.abhinav.controller;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abhinav.models.Client;

public interface TestRepository extends MongoRepository<Client, String>{


}
