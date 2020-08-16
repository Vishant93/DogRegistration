package com.vishant.sandwichtechnologies;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DogInfo")
public class Dog {

	  @Id
	  public String id;
	  
	  public String dogName;
	  public int dogAge;
	  public String dogBreed;

	  public Dog() {}

	  public Dog(String dogName, int dogAge, String dogBreed) {
	    this.dogName = dogName;
	    this.dogAge = dogAge;
	    this.dogBreed = dogBreed;
	  }

	@Override
	public String toString() {
		return "Dog [id=" + id + ", dogName=" + dogName + ", dogAge=" + dogAge + ", dogBreed=" + dogBreed + "]";
	}
	  
}
