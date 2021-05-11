package fr.formation.afpa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.afpa.domain.Compte;
import fr.formation.afpa.domain.Employee;
import fr.formation.afpa.service.ServiceCompte;
import fr.formation.afpa.service.ServiceEmploye;

@Controller
public class LogController {

	ServiceCompte service;
	ServiceEmploye serviceEmp;

	public LogController() {
		System.out.println("constructeur logController Vide");
	}

	@Autowired
	public LogController(ServiceCompte service, ServiceEmploye serviceEmp) {
		System.out.println("constructeur controller compte");
		this.service = service;
		this.serviceEmp = serviceEmp;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHome(Model m) {

		m.addAttribute("compte", new Compte());

		return "login";

	}

	/*
	 * Méthode validation Login qui donne accès à l'accueil
	 */
	@RequestMapping(path = "/accueil", method = RequestMethod.POST)
	public String getAccueil(Compte compte, BindingResult result) {
		try {

			if (service.validation(compte.getLogin(), compte.getPassword()) != null) {

				return "accueil";
			} else {
				System.out.println("login ou mdp incorrect");
				return "login";
			}

		} catch (NoResultException nre) {
			System.out.println("je suis nulle");
			return "login";
		}

	}
   /* Affiche la liste des employés*/
	@RequestMapping(path = "/employe", method = RequestMethod.POST)
	public String getEmploye(Model m) {

		List<Employee> employees = serviceEmp.findAll();
		m.addAttribute("employees", employees);

		return "employes";

	}
	
	/*Redirect vers la page d'accueil qd on est connecté*/
	@RequestMapping(path = "/accueilConnecte", method = RequestMethod.GET)
	public String getAccueilConnecte() {

		return "accueil";
	}
	/*affiche l'ajout employé la première fois*/
	@RequestMapping(path = "/ajoutEmploye", method = RequestMethod.GET)
	public String getAjoutEmploye(Model m) {
		List<Employee> employees = serviceEmp.findAll();
		System.out.println(employees);
		m.addAttribute("emp",new Employee());
		m.addAttribute("employees", employees);
		
		
		return "ajoutEmploye";
	}
	
	/*Enregistre l'employé en bdd*/
	@RequestMapping(path = "/ajoutEmploye", method = RequestMethod.POST)
	public String getSaveEmploye(@ModelAttribute Employee emp, BindingResult result,@RequestParam Integer manager,Date startDate) {
		System.out.println("manager " +manager);
		System.out.println("startDate " +startDate);
		Employee employe = serviceEmp.findById(manager);
		
		
		emp.setManager(employe);
		System.out.println(emp);
	
		serviceEmp.save(emp);
	
		return "accueil";
	}
	
	 /* Affiche la liste des managers*/
		@RequestMapping(path = "/manager", method = RequestMethod.POST)
		public String getManager(Model m) {

			List<Employee> managers = serviceEmp.findManagers();
			System.out.println(managers);
			m.addAttribute("managers", managers);

			return "manager";

		}
		
		
		
		
		
		
		/* Affiche la page des paramètres*/
		@RequestMapping(path = "/parametres", method = RequestMethod.GET)
		public String getParametres(Model m) {
			List<Employee> managers = serviceEmp.findManagers();
			List<Employee> empSansManag = serviceEmp.findEmpSansManager();
			System.out.println(empSansManag);
			m.addAttribute("emp",new Employee());
			m.addAttribute("parametres", empSansManag);
			m.addAttribute("managers", managers);
			return "parametre";

		}
		/* Valide le changement des paramètres*/
		@RequestMapping(path = "/parametres", method = RequestMethod.POST)
		public String getValidParametres(@ModelAttribute Employee emp, BindingResult result,@RequestParam Integer manager,Date startDate) {
			
			System.out.println(emp);
			return "parametre";

		}
	
	
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(
	        dateFormat, false));
	}

}
