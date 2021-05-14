package fr.formation.afpa.dao;

import fr.formation.afpa.domain.Department;

public interface IDepartmentDaoJpa {

	Department findById(Integer id);
}
