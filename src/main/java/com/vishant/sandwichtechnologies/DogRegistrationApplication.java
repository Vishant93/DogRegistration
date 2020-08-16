package com.vishant.sandwichtechnologies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogRegistrationApplication implements CommandLineRunner {
	@Autowired
	DogRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DogRegistrationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// put down the dogs
		repository.deleteAll();

	    // save a couple of dogs
	    repository.save(new Dog("Ruffles", 3, "Labrador Retriever"));
	    repository.save(new Dog("Pinto", 5, "Jack Russell Terrier"));
	    repository.save(new Dog("Coco", 9, "Maltipoo"));
	}

}
