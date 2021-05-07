package fr.formation.afpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_cd", unique = true, nullable = false)
	private String productCd;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_offered", nullable = false)
	private Date dateOffered;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_retired", nullable = true)
	private Date dateRetired;

	@Column(name = "name")
	private String name;

	@OneToOne
	@JoinColumn (name = "product_type_cd",nullable = false)
	private ProductType productType;

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public Date getDateOffered() {
		return dateOffered;
	}

	public void setDateOffered(Date dateOffered) {
		this.dateOffered = dateOffered;
	}

	public Date getDateRetired() {
		return dateRetired;
	}

	public void setDateRetired(Date dateRetired) {
		this.dateRetired = dateRetired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [productCd=" + productCd + ", dateOffered=" + dateOffered + ", dateRetired=" + dateRetired
				+ ", name=" + name + ", productType=" + productType + "]";
	}


	
}
