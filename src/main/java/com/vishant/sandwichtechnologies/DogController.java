package com.vishant.sandwichtechnologies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class DogController {
	@Autowired 
	DogRepository dogRepository;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
		return String.format("Hello, %s", name);
	}
	
	@GetMapping("/dogs")
	public List<Dog> getDogs() {
		return dogRepository.findAll();
	}
	
	@GetMapping("/dogs/{id}")
	public Optional<Dog> getDog(@PathVariable String id) {
		return dogRepository.findById(id);
	}
	
	@PostMapping("/dogs")
	public Dog createDog(@RequestBody Dog dog) {
		return dogRepository.save(dog);
	}
		
	//update
	@PutMapping("/dogs/{id}")
	public ResponseEntity <Dog> updateDog(@PathVariable String id, @RequestBody Dog DogDetails) {
		Dog Dog = dogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Dog does not exist with id:" + id));
		Dog.setDogName(DogDetails.getDogName());
		Dog.setDogBreed(DogDetails.getDogBreed());
		Dog.setDogAge(DogDetails.getDogAge());
		Dog updatedDog = dogRepository.save(Dog);
		return ResponseEntity.ok(updatedDog);
	}
		
	//delete
	@DeleteMapping("dogs/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteDog(@PathVariable String id) {
		Dog Dog = dogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Dog does not exist with id:" + id));
		dogRepository.delete(Dog);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
