package fr.formation.afpa.domain;

import java.util.List;

public class EmployeeForm {

	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "EmployeeForm [employees=" + employees + "]";
	}
	
}
