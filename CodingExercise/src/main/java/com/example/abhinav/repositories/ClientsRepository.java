package com.example.abhinav.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.abhinav.models.Client;

/**
 * @author Abhinav
 *
 */
public interface ClientsRepository extends MongoRepository<Client, String> {

	Client findBy_id(String _id);

	List<Client> findAll();

	Client insert(Client cli);

}
