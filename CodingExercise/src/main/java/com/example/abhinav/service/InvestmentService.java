package com.example.abhinav.service;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;

public interface InvestmentService {
	Document findClientById(String _id);
	FindIterable<Document> findAllClient();
	Document getInvestorFundList(String _id);
	boolean saveClients(JSONObject json);
	boolean updateClients(JSONObject json, String _id);
}
