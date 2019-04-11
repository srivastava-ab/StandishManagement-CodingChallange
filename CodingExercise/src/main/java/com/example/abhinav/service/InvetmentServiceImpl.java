package com.example.abhinav.service;

import org.bson.Document;
import org.json.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InvetmentServiceImpl implements InvestmentService {

	static MongoClient mongoClient = MongoClients.create();
	// Connect to db
	static MongoDatabase db = mongoClient.getDatabase("invest");
	static MongoCollection<Document> clientsCollection = db.getCollection("clients");
	static MongoCollection<Document> investorsCollection = db.getCollection("investors");
	static MongoCollection<Document> fundsCollection = db.getCollection("funds");

	@Override
	public FindIterable<Document> findAllClient() {
		System.out.println("In services");
		FindIterable<Document> docs = clientsCollection.find();
		if (docs == null) {
			System.out.println("NULL");
			return null;
		}
		for (Document doc : docs) {
			System.out.println(doc.get("name"));
		}
		return docs;
	}

	@Override
	public Document findClientById(String id) {
		System.out.println("In services");
		BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		FindIterable<Document> docs = clientsCollection.find(query);
		if (docs == null) {
			System.out.println("NULL");
			return null;
		}
		for (Document doc : docs) {
			System.out.println(doc.get("name"));
			return doc;
		}
		return null;
	}

	@Override
	public Document getInvestorFundList(String _id) {
		System.out.println("In services");
		BasicDBObject query = new BasicDBObject();
		query.put("_id", _id);
		FindIterable<Document> docs = investorsCollection.find(query);
		if (docs == null) {
			System.out.println("NULL");
			return null;
		}
		for (Document doc : docs) {
			System.out.println(doc.get("name"));
			return doc;
		}
		return null;
	}

	@Override
	public boolean saveClients(JSONObject json) {
		Document doc = Document.parse(json.toString());
		BasicDBObject query = new BasicDBObject();
		query.putAll(doc);
		clientsCollection.insertOne(doc);
		System.out.println("Done");
		return true;

	}

	@Override
	public boolean updateClients(JSONObject json, String _id) {

		Document doc = Document.parse(json.toString());
		BasicDBObject query = new BasicDBObject();
		query.append("_id", _id);
		BasicDBObject obj = new BasicDBObject();
		obj.putAll(doc);
		Document filter = new Document();
		filter.append("_id", _id);
		// query.putAll(doc);
		Document res = (Document) clientsCollection.find(query);
		System.out.println("Done update");
		return true;

	}

}
