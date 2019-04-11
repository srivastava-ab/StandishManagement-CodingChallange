package com.example.abhinav.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.abhinav.models.Client;
import com.example.abhinav.models.ClientException;
import com.example.abhinav.repositories.ClientsRepository;

/**
 * @author Abhinav
 *
 */
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	ClientsRepository clientRepo;

	public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	/**
	 * Returns a JSONArray of all client objects from DB
	 * 
	 * @return ResponseEntity<?>
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> findAllClients() {
		logger.info("Getting all clients");
		return new ResponseEntity<List<Client>>(clientRepo.findAll(), HttpStatus.OK);

	}

	/**
	 * For provided client id, looksup in clients collection for that record and
	 * returns a client object
	 * 
	 * @param id
	 * @return ResponseEntity<Object>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> getClientById(@PathVariable("id") String id) {
		logger.info("Getting client with id {}", id);
		Client cli = clientRepo.findBy_id(id);
		return new ResponseEntity<Object>((cli != null ? cli : "Id not present in DB"), HttpStatus.OK);
	}

	/**
	 * Updates the record matching 'id' with Client object 'clients'
	 * 
	 * @param id
	 * @param clients
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public void updateClient(@PathVariable("id") String id, @RequestBody Client clients) {
		logger.info("Updating client id {}", id);
		clients.set_id(id);
		System.out.println(clients.get_id() + " :: " + clients.getName() + " :: " + clients.getInvestors());
		clientRepo.save(clients);
	}

	/**
	 * Saves a client object in db
	 * 
	 * @param clients
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Object> createClient(@Valid @RequestBody Client clients) {
		logger.info("Adding a new client");
		Client cli = new Client();
		try {
			cli = clientRepo.insert(clients);
		} catch (Exception e) {
			throw new ClientException(cli._id);
		}
		return new ResponseEntity<Object>(cli, HttpStatus.OK);
	}
}
