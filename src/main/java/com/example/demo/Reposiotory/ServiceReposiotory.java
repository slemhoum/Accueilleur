package com.example.demo.Reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Service;

public interface ServiceReposiotory  extends JpaRepository<Service, Long>{

}
