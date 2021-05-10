package fr.formation.afpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import fr.formation.afpa.domain.Compte;

@Repository
public class CompteDaoJpa implements ICompteDaoJpa{
	private EntityManagerFactory enf;
	private EntityManager em;
	
	
	public CompteDaoJpa() {
		enf = Persistence.createEntityManagerFactory("unitBD");
		em=enf.createEntityManager();
	}
	
	
	public void beginTransaction() {
		em = enf.createEntityManager();
		em.getTransaction().begin(); //charge la transaction
	}
	
	public void commitTransaction() {
		em.getTransaction().commit();//fin de la transaction soit begin soit rollback
	}
	public void rollBackTransaction() {
		em.getTransaction().rollback();//fin de la transaction soit begin soit rollback
		
	}	
	
	public Compte validation(String log, String mdp) {
	
		System.out.println("je suis dans la méthode comptedaoJpa");

		String hql = "from Compte where login = :login";
		Compte compte = (Compte) em.createQuery(hql).setParameter("login", log).getSingleResult();
		if (compte != null && compte.getPassword().equals(mdp)&& compte.getLogin().equals(log)) {
			System.out.println(compte.getLogin());
			System.out.println(compte.getPassword());
			return compte;
			
		} else {
			System.out.println("pas le bon mdp");
			return null;
			
		}
		
	}

	
}
