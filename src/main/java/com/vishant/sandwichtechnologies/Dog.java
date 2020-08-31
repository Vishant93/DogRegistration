package com.vishant.sandwichtechnologies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DogInfo")
public class Dog {

	@Id
	private String id;
	
	private String dogName;
	private int dogAge;
	private String dogBreed;

	public Dog() {}

	public Dog(String dogName, int dogAge, String dogBreed) {
	    this.dogName = dogName;
	    this.dogAge = dogAge;
	    this.dogBreed = dogBreed;
	}
	  
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public int getDogAge() {
		return dogAge;
	}

	public void setDogAge(int dogAge) {
		this.dogAge = dogAge;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}
	  
}
