package com.example.abhinav.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Abhinav
 *
 */
@Document(collection = "investors")
public class Investor {

	@Id
	@NotEmpty(message = "Id is a required field")
	public String _id;
	@NotEmpty(message = "Name is a required field")
	public String name;
	@NotEmpty(message = "Desc is a required field")
	public String description;
	@NotEmpty(message = "Funds is a required field")
	public int[] funds;
	
	
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
	public int[] getFunds() {
		return funds;
	}
	public void setFunds(int[] funds) {
		this.funds = funds;
	}
}
