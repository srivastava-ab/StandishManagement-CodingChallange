package com.example.abhinav.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * Model class of Client 
 * 
 * @author Abhinav
 *
 */
@Document(collection = "clients")
public class Client {
	@Id
	@NotEmpty(message = "Id is a required field")
	public String _id;
	@NotEmpty(message = "Name is a required field")
	public String name;
	@NotEmpty(message = "Desc is a required field")
	public String description;
	@NotEmpty(message = "Investors is a required field")
	public int[] investors;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int[] getInvestors() {
		return investors;
	}

	public void setInvestors(int[] investors) {
		this.investors = investors;
	}
}
