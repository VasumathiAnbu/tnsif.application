package com.tnsif.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.application.entity.Application;
import com.tnsif.application.repository.ApplicationRepository;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationRepository repo;
	
	@PostMapping("/application")
	public Application addApplication (@RequestBody Application a){
	
		return repo.save(a);
	}
	
	@GetMapping("/application")
	public List<Application> getApplications()
	{
		return repo.findAll();
	}
	
	@GetMapping("/application/{applicationId}")
	public Application getApplicationById(@PathVariable Integer applicationId) 
	{
		
		return repo.findById(applicationId).get();
	}
	
	@DeleteMapping("/application/{applicationId}")
	public void deleteApplication(@PathVariable Integer applicationId)
	{
		repo.deleteById(applicationId);
	}
	
	@PutMapping("/application/{applicationId}")
	public Application updateApplication(@PathVariable Integer applicationId, @RequestBody Application a)
	{
		a.setApplicationId(applicationId);
		return repo.save(a);
	}

}
