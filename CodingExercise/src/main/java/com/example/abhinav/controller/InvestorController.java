package com.example.abhinav.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.abhinav.models.Client;
import com.example.abhinav.models.Investor;
import com.example.abhinav.repositories.InvestorsRepository;

/**
 * @author Abhinav
 *
 */
@RestController
@RequestMapping("/investors")
public class InvestorController {

	@Autowired
	InvestorsRepository investRepo;

	public static final Logger logger = LoggerFactory.getLogger(InvestorController.class);

	/**
	 * For provided investor id, looksup in investor collection for that record 
	 * and returns an investor object
	 * 
	 * @param id
	 * @return ResponseEntity<List<Investor>>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Investor>> getInvestorById(@PathVariable("id") int[] id) {
		logger.info("Getting investor with id {}", id);
		List<Investor> list = new ArrayList<>();
		for (int i : id) {
			Investor investor = investRepo.findBy_id(String.valueOf(i));
			list.add(investor);
		}
		// Investor investor = fundsRepo.findBy_id(id);
		return new ResponseEntity<List<Investor>>(list, HttpStatus.OK);
	}
}
