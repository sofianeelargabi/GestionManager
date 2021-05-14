package fr.formation.afpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import fr.formation.afpa.domain.Department;
import fr.formation.afpa.domain.Employee;

@Repository
public class DepartmentDaoJpa implements IDepartmentDaoJpa  {
	
	private EntityManagerFactory enf;
	private EntityManager em;
	
	
	public DepartmentDaoJpa() {
		enf = Persistence.createEntityManagerFactory("unitBD");
		em = enf.createEntityManager();
		
	}
	public void beginTransaction() {
		em = enf.createEntityManager();
		em.getTransaction().begin(); // charge la transaction
	}

	public void commitTransaction() {
		em.getTransaction().commit();// fin de la transaction soit begin soit rollback
	}

	public void rollBackTransaction() {
		em.getTransaction().rollback();// fin de la transaction soit begin soit rollback
	}
	@Override
	public Department findById(Integer id) {

		return em.find(Department.class, id);	}
	
}
