package fr.formation.afpa.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//	binder.registerCustomEditor(Date.class, new CustomDateEditor(
//	        dateFormat, false));
//	}

}
