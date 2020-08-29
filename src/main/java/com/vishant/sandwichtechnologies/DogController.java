package com.vishant.sandwichtechnologies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
	@Autowired 
	DogRepository dogRepository;
	
	@GetMapping("/dogs")
	public List<Dog> getDogs() {
		return dogRepository.findAll();
	}
	
	@PostMapping("/dogs")
	public Dog createDog(@RequestBody Dog dog) {
		return dogRepository.save(dog);
	}
}
