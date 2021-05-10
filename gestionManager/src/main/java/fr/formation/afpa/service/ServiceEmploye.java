package fr.formation.afpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.afpa.dao.IEmployeeDaoJpa;
import fr.formation.afpa.domain.Employee;

@Service
@Transactional
public class ServiceEmploye {

	@Autowired
	private IEmployeeDaoJpa dao;

	public ServiceEmploye() {
		System.out.println("Instance service Employé");
	}

	public List<Employee> findAll() {

		List<Employee> employees = dao.findAll();

		return employees;

	}

	public void setDao(IEmployeeDaoJpa dao) {
		this.dao = dao;
	}

}