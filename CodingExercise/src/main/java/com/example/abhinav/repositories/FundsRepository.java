package com.example.abhinav.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abhinav.models.Fund;

/**
 * @author Abhinav
 *
 */
public interface FundsRepository extends MongoRepository<Fund, String>{
	
	Fund findBy_id(String id);

}
