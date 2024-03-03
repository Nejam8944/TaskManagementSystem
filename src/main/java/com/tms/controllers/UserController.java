package com.tms.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.DTO.UserDTO;
import com.tms.entities.User;
import com.tms.projection.UserProjection;
import com.tms.repositories.UserRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/users")
@CacheConfig(cacheNames = "user")
public class UserController {

	@Autowired
	UserRepository repo;

	@GetMapping("/getRequired")
	public List<UserProjection> getUserRequiredAttributes(){
		
		return repo.findUsersWithRequiredAttributes();
	}
	
	@PostMapping("/postRequired")
	public String addUsersWithRequiredAttributes(@RequestBody Map<String, String> request) {
		String userName = request.get("userName");
		String email = request.get("email");
		repo.addUsersWithRequiredAttributes(userName, email);
		return "Post success";
	}

	@GetMapping("/emaildomain/{domain}")
	@Cacheable(key = "#domain")
	public ResponseEntity<?> getUserByEmailDomain(@PathVariable() String domain) {
		List<String> domains = Arrays.asList("email", "gmail", "yahoo", "capgemini", "hotmail", "outlook");
		if(domains.contains(domain))
			return new ResponseEntity<List<User>>(repo.findByEmailContainingIgnoreCase(domain), HttpStatus.OK);
		return new ResponseEntity<String>("Invalid domain name",HttpStatus.OK);
	}
	
	@GetMapping("/most-task")
	public ResponseEntity<User> getUserAssignedMostTask() {
		User user = repo.findUserAssignedMostTask();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/completed-tasks")
	public ResponseEntity<?> getUserWhoCompletedTask() {
		List<User> users = repo.findByCompletedtask();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	@CachePut(key = "#id")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
			return repo.save(user);
	}
	
	@DeleteMapping("delete/{id}")
	@CacheEvict(key = "#id")
	public void deleteUser(@PathVariable int id) {
		
		repo.deleteById(id);
	}
	@GetMapping("/getAll")
	@Cacheable(key = "getall")
	public List<User> getMethodName() {
		return repo.findAll();
	}
	
	@GetMapping("/get/{id}")
	@Cacheable(key = "#id")
	public User getUser(@PathVariable int id) {
		return repo.findById(id).get();
	}
	
}
