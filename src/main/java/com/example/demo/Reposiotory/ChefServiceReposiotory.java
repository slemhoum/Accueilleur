package com.example.demo.Reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Accueilleur;
import com.example.demo.entities.ChefService;
import com.example.demo.entities.Service;

public interface ChefServiceReposiotory  extends JpaRepository<ChefService, Long>{
	

}