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

import com.example.abhinav.models.Fund;
import com.example.abhinav.repositories.FundsRepository;

/**
 * @author Abhinav
 *
 */
@RestController
@RequestMapping("/funds")
public class FundController {

	@Autowired
	FundsRepository fundsRepo;

	public static final Logger logger = LoggerFactory.getLogger(FundController.class);

	/**
	 * For provided fund id, lookup in fund collection for that record 
	 * and returns a fund object
	 * 
	 * @param id
	 * @return ResponseEntity<List<Fund>>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Fund>> getFundById(@PathVariable("id") int[] id) {
		logger.info("Getting funds with id {}", id);
		List<Fund> list = new ArrayList<>();
		for (int i : id) {
			Fund fund = fundsRepo.findBy_id(String.valueOf(i));
			list.add(fund);
		}
		return new ResponseEntity<List<Fund>>(list, HttpStatus.OK);
	}
}
