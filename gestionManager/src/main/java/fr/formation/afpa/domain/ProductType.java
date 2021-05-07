package fr.formation.afpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Table(name = "product_type")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String product_type_cd;
	
	@Column(name = "name")
	private String name;

	@Override
	public String toString() {
		return "ProductType [product_type_cd=" + product_type_cd + ", name=" + name + "]";
	}
	
	
}
