package fr.formation.afpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.afpa.dao.ICompteDaoJpa;
import fr.formation.afpa.domain.Compte;


@Service
@Transactional
public class ServiceCompte {

	@Autowired
	private ICompteDaoJpa dao;
	
	public ServiceCompte() {
		
		System.out.println("Instance service Compte");
	}
	public Compte validation(String login, String pwd) {
		System.out.println("je suis dans la méthode serviceCompte");
	
		Compte compte = dao.validation(login, pwd);
	//	dao.validation(login, pwd);
		System.out.println("ici");
		return compte;
		
		
	}
	public ICompteDaoJpa getDao() {
		return dao;
	}
	public void setDao(ICompteDaoJpa dao) {
		this.dao = dao;
	}

}
