package fr.formation.afpa.service;

import java.util.List;

import fr.formation.afpa.domain.Compte;


public interface IServiceDaoJpa {
	
	//read
	Compte findById(Integer id);
	List<Compte> findAll();
	
	//create
	Integer save(Compte e);
	
	//update
	Compte update(Compte e);
	
	//delete
	void delete(Compte e);
	void deleteById(Integer id);

}
