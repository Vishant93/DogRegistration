package com.vishant.sandwichtechnologies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DogRegistrationApplication implements CommandLineRunner{
	@Autowired DogRepository dogRepository;

	public static void main(String[] args) {
		SpringApplication.run(DogRegistrationApplication.class, args);
	}
	@Override
	  public void run(String... args) throws Exception {
		dogRepository.deleteAll();
		dogRepository.save(new Dog("Sparkle Puff", 3, "Dachshund"));
		dogRepository.save(new Dog("Bubbles", 3, "Great Dane"));
		dogRepository.save(new Dog("Cerebrus", 3, "Chihuahua"));
	}
}
