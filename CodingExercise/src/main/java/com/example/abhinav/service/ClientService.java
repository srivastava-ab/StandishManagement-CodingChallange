package com.example.abhinav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abhinav.models.Client;
import com.example.abhinav.repositories.ClientsRepository;

@Service
public class ClientService {

	@Autowired
	ClientsRepository cli;
	
	public Client findOne(String id) {
		System.out.println("*************HEllo**********");
		Client c =  cli.findBy_id(id);
		return c;
	}
	
}
