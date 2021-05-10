package fr.formation.afpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.afpa.service.ServiceEmploye;

@Controller
public class EmployeController {

	@Autowired
	private ServiceEmploye service;
	
	
	public EmployeController() {

	}
	
	public EmployeController(ServiceEmploye service) {
		System.out.println("controller employe");
		this.service=service;
	}
	

	
}
