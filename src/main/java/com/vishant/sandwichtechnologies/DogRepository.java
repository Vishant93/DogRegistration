package com.vishant.sandwichtechnologies;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DogRepository extends MongoRepository<Dog, String> {
	public Dog findByDogName(String dogName);
	public List<Dog> findByDogBreed(String dogBreed);
}
