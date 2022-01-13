package com.dsaurabh.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsaurabh.demo.Model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

}
