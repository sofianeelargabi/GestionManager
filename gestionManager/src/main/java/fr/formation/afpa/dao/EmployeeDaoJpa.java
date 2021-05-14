package fr.formation.afpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.formation.afpa.domain.Employee;

@Repository
public class EmployeeDaoJpa implements IEmployeeDaoJpa {
	private EntityManagerFactory enf;
	private EntityManager em;

	public EmployeeDaoJpa() {
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

	public Employee findById(Integer id) {
		return em.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		return em.createQuery("select emp from Employee emp").getResultList();
	}

	public Integer save(Employee e) {
		beginTransaction();
		em.persist(e);
		commitTransaction();
		return e.getEmpId();
	}

	public Employee update(Employee e) {
		beginTransaction();
		 em.merge(e);
		 commitTransaction();
		return e;
	}

	public void delete(Employee e) {
		em.remove(e);
	}

	public void deleteById(Integer id) {
		beginTransaction();
		Employee emp = findById(id);
		delete(emp);
		commitTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findManagers() {

		List<Employee> list = em
				.createQuery("from Employee WHERE empId IN (SELECT manager FROM Employee))", Employee.class)
				.getResultList();
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findEmpSansManager() {

		String hql = ("from Employee where manager=null");
		List<Employee> list = em.createQuery(hql).getResultList();

		return list;
	}

	public List<Employee> getSubordonnes(Integer empId) {
		String hql = "from Employee where manager.empId = :empId";
		List<Employee> list = em.createQuery(hql, Employee.class).setParameter("empId", empId).getResultList();
		return list;

	}

}
