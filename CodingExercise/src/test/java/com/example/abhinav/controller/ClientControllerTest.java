package com.example.abhinav.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.abhinav.models.Client;

/**
 * @author grtab
 *
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class ClientControllerTest {

	@Autowired
	TestRepository cliRepo;

	List<Client> list = new ArrayList<>();

	/**
	 * 
	 * Creates 10 client objects and save it in test collection Also, these client
	 * obj's are added to list for further use
	 * 
	 */
	@Before
	public void before() {
		int[] arr = { 1, 2 };
		for (int i = 0; i < 10; i++) {
			Client clientToTest = new Client();
			clientToTest.setInvestors(arr);
			clientToTest.set_id(String.valueOf(i));
			clientToTest.setDescription("Test " + i);
			clientToTest.setName("TestName " + i);
			Client t = cliRepo.save(clientToTest);
			list.add(clientToTest);
		}
	}

	@After
	public void after() {
		cliRepo.deleteAll();
	}

	/**
	 * Creates a Client obj and inserts in test collection and then checks if the
	 * client obj is inserted in DB or not
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateClient() throws Exception {
		int[] arr = { 1, 3 };
		Client clientToTest = new Client();
		clientToTest.setInvestors(arr);
		clientToTest.set_id("100");
		clientToTest.setDescription("Test 100");
		clientToTest.setName("TestName 100");
		Client t = cliRepo.save(clientToTest);
		assertTrue(cliRepo.existsById("100"));
	}

	/**
	 * Checks the collection for already present record with id
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetClientById() throws Exception {
		assertFalse(cliRepo.existsById("13"));
		assertTrue(cliRepo.existsById("9"));
	}

	/**
	 * Gets the list of all the Client document and save it in List<Client>
	 * actualList Iterates over all the elements of actualList and list(created
	 * while setting up test db) Compares name and id of both the lists
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFindAllClients() throws Exception {
		List<Client> actualList = cliRepo.findAll();
		for (int i = 0; i < list.size(); i++) {
			assertTrue(list.get(i).getName().equals(actualList.get(i).getName()));
			assertTrue(list.get(i).get_id().equals(actualList.get(i).get_id()));
		}

	}

}
