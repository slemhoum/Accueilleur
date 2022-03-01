package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Reposiotory.AccReposiotory;
import com.example.demo.Reposiotory.ClientRepository;
import com.example.demo.Reposiotory.DemandeReposiotory;
import com.example.demo.Reposiotory.ServiceReposiotory;
import com.example.demo.entities.Accueilleur;
import com.example.demo.entities.Client;
import com.example.demo.entities.Demande;
import com.example.demo.entities.Service;
@SpringBootApplication
public class ProjetPlatServApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private DemandeReposiotory demandeReposiotory;
	@Autowired
	private ServiceReposiotory serviceReposiotory;
	@Autowired
	private AccReposiotory accReposiotory;
	public static void main(String[] args) {
	SpringApplication.run(ProjetPlatServApplication.class, args);
	
	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Client c1=clientRepository.save(new Client("med","ahmed","mryta","123","2828939","CLIENT"));
//		Service s=serviceReposiotory.getById((long) 1);
//		Accueilleur a=accReposiotory.getById((long) 1);
//		Demande d1=demandeReposiotory.save(new Demande("ty betr","6mais","en atent",new Date(),s,c1,a));
	}

}
