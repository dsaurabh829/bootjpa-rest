package com.dsaurabh.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsaurabh.demo.Model.Alien;
import com.dsaurabh.demo.Repo.AlienRepo;

@RestController
public class HomeController {
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path = "/aliens", produces = {"application/json"})
	public List getAllAlien() {
		return repo.findAll();
	}
	
	@PostMapping(path = "/addAlien" , consumes = {"application/json"})
	public String addAlien(@RequestBody Alien al) {
		
		repo.save(al);
		
		return (al.getAname() +  " is added to Alien table" );
		
	}
	
	@GetMapping(path = "/alien/{id}")
	public Optional<Alien> getAlien(@PathVariable("id") int aid) {
		
		return repo.findById(aid);
		
	}
	
	@DeleteMapping(path = "/alien/{id}")
	public String deleteAlien(@PathVariable("id") int aid) {
		
		int id = aid;
		repo.deleteById(aid);
		return (id + " Deleted from Alien Table");
	}

}
