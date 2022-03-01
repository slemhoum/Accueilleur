package com.example.demo.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Reposiotory.AccReposiotory;
import com.example.demo.Reposiotory.ChefProjetReposiotory;
import com.example.demo.Reposiotory.ChefServiceReposiotory;
import com.example.demo.Reposiotory.ClientRepository;
import com.example.demo.Reposiotory.DemandeReposiotory;
import com.example.demo.Reposiotory.DirecteurReposiotory;
import com.example.demo.Reposiotory.MemberReposiotory;
import com.example.demo.Reposiotory.ProjetReposiotory;
import com.example.demo.Reposiotory.ServiceReposiotory;
import com.example.demo.entities.Accueilleur;
import com.example.demo.entities.ChefProjet;
import com.example.demo.entities.ChefService;
import com.example.demo.entities.Client;
import com.example.demo.entities.Demande;
import com.example.demo.entities.Directeur;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Projet;
import com.example.demo.entities.Service;

@Controller
public class MonController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private DemandeReposiotory demandeReposiotory;
	@Autowired
	private ServiceReposiotory serviceReposiotory;
	@Autowired
	private AccReposiotory accReposiotory;
	@Autowired
	private ChefServiceReposiotory chefServiceReposiotory;
	@Autowired
	private MemberReposiotory memberReposiotory;
	@Autowired
	private ChefProjetReposiotory chefProjetReposiotory;
	@Autowired
	private DirecteurReposiotory directeurReposiotory;
	@Autowired
	private ProjetReposiotory projetReposiotory;
	@RequestMapping(value="/index")
	public String index(Model model) {
    List<Demande> demandes=demandeReposiotory.findAll();
    long d=demandeReposiotory.count();
    String att="refuse";
    List<Demande>drf=demandeReposiotory.dstatus(att);
    List<Demande>dac=demandeReposiotory.dstatus("accepter");
    List<Demande>dat=demandeReposiotory.dstatus("En attent");
    int da=dat.size();
    int dr=drf.size();
    int dacc=dac.size();
    model.addAttribute("listdemandes",dat);
    model.addAttribute("d",d);
    model.addAttribute("da",da);
    model.addAttribute("dr",dr);
    model.addAttribute("dacc",dacc);
		return "accDach";
		
	}
	@RequestMapping(value="/Client")
	public String client(Model model) {
    List<Client> clients=clientRepository.findAll();
    model.addAttribute("listclients",clients);
    model.addAttribute("client",new Client());
	return "client";
		
	}
	@RequestMapping(value="/saveC" ,method=RequestMethod.POST)
	public String saveC(Model model,Client client) {
    clientRepository.save(client);
    return "redirect:/Client";
		
	}
	@RequestMapping(value="/editC",method=RequestMethod.GET)
	public String editC(Model model,Long id) {
  Client c=clientRepository.getById(id);
    model.addAttribute("client",c);
			return "Editclient";
	}
	@RequestMapping(value="/EditC",method=RequestMethod.GET)
	public String EditC(Model model,Long id) {
    Client c=clientRepository.getById(id);
    model.addAttribute("client",c);
			return "redirect:/Client";
	}
	@RequestMapping(value="/deleteC",method = RequestMethod.GET)
	public String deleteC(Long id) {
		clientRepository.deleteById(id);
			return "redirect:/Client";
			
		}
	
//	demandeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee	
		
	@RequestMapping(value="/Demande")
	public String demande(Model model) {
    List<Demande> demandes=demandeReposiotory.findAll();
    List<Client>clients=clientRepository.findAll();
    List<Service>services=serviceReposiotory.findAll();
    List<Accueilleur>accs=accReposiotory.findAll();
    model.addAttribute("cl",clients);
    model.addAttribute("acc",accs);
    model.addAttribute("sr",services);
    model.addAttribute("listdemandes",demandes);
    model.addAttribute("demande",new Demande());
	return "Demande";
		
	}	
	@RequestMapping(value="/saveD" ,method=RequestMethod.POST)
	public String saveD(Model model,Demande demande) {
		demande.setDate_creation(new Date());
		demande.setStatus("En attent");
    demandeReposiotory.save(demande);
    return "redirect:/Demande";
		
	}
	@RequestMapping(value="/deleteD",method = RequestMethod.GET)
	public String deleteD(Long id) {
		demandeReposiotory.deleteById(id);
			return "redirect:/Demande";
			
		}
	@RequestMapping(value="/editD",method=RequestMethod.GET)
	public String editD(Model model,Long id) {
    Demande d=demandeReposiotory.getById(id);
    List<Client>clients=clientRepository.findAll();
    List<Service>services=serviceReposiotory.findAll();
    List<Accueilleur>accs=accReposiotory.findAll();
    model.addAttribute("cl",clients);
    model.addAttribute("acc",accs);
    model.addAttribute("sr",services);
    model.addAttribute("demande",d);
			return "Editdemande";
	}
	@RequestMapping(value="/EditD",method=RequestMethod.POST)
	public String EditD(Model model,Demande demande) {
		demande.setDate_creation(new Date());
		demande.setStatus("En attent");
    demandeReposiotory.save(demande);
    return "redirect:/Demande";
	}
//	Dircteurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
	@RequestMapping(value="/dicD")
	public String dicD(Model model) {
   
	return "home";
		
	}
	@RequestMapping(value="/ServiceA")
	public String ServiceA(Model model) {
    List<Service> clients=serviceReposiotory.findAll();
    List<ChefService>chS=chefServiceReposiotory.findAll();
    model.addAttribute("chS",chS);
    model.addAttribute("listservices",clients);
    model.addAttribute("client",new Client());
	return "service";
		
	}
	@RequestMapping(value="/saveS" ,method=RequestMethod.POST)
	public String saveS(Model model,Service service) {
		 Directeur d=directeurReposiotory.getById((long) 1);
		service.setDirecteur(d);
       serviceReposiotory.save(service);
    return "redirect:/ServiceA";
		
	}
	@RequestMapping(value="/deleteS",method = RequestMethod.GET)
	public String deleteS(Long id) {
		serviceReposiotory.deleteById(id);
			return "redirect:/ServiceA";	
		}
	@RequestMapping(value="/editS",method=RequestMethod.GET)
	public String editS(Model model,Long id) {
  Service c=serviceReposiotory.getById(id);
  List<ChefService>chS=chefServiceReposiotory.findAll();
  model.addAttribute("chS",chS);
   model.addAttribute("client",c);
			return "Editservice";
	}
	@RequestMapping(value="/DetailS",method=RequestMethod.GET)
	public String DetailS(Model model,Long id) {
    Service c=serviceReposiotory.getById(id);
    List<Projet>p=projetReposiotory.projetParS(c);
    List<ChefProjet>chefp=chefProjetReposiotory.ChefProjetParS(c);
    List<Membre>member=memberReposiotory.MembreParS(c);
    List<ChefService>chS=chefServiceReposiotory.findAll();
    model.addAttribute("chefp",chefp);
    model.addAttribute("chS",chS);
    model.addAttribute("member",member);
    model.addAttribute("listclients",p);
    model.addAttribute("client",c);
			return "Detail";
	}
}
