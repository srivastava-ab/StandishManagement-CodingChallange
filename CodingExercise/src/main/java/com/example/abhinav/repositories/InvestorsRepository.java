package com.example.abhinav.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.abhinav.models.Investor;

/**
 * @author Abhinav
 *
 */
public interface InvestorsRepository extends MongoRepository<Investor, String> {

	Investor findBy_id(String _id);
}
