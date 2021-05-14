package fr.formation.afpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.afpa.dao.IDepartmentDaoJpa;
import fr.formation.afpa.domain.Department;

@Service
@Transactional
public class ServiceDepartment {

	@Autowired
	private IDepartmentDaoJpa dao;
	
	public ServiceDepartment() {
	}
	
	public Department findById(Integer id) {
		return dao.findById(id);
	}
}
