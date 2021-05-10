package fr.formation.afpa.dao;



import fr.formation.afpa.domain.Compte;


public interface ICompteDaoJpa {

	Compte validation(String login, String password);
}
