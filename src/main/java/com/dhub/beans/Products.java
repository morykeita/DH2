package com.dhub.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Products implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5989497788339985728L;

	@Id
	@Column(name="PRODUCT_ID")
	@SequenceGenerator(name="PRODUCT_SEQ", sequenceName="PRODUCT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_SEQ")
	private Integer productId;
	
	@Column(name="PRODUCT")
	private String product;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="PROJECTS_PRODUCTS",
		joinColumns = @JoinColumn(name = "PRODUCT_ID"),
			inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	private List<Projects> projects;
	
	public Products() {
		
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", product=" + product + "]";
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}	
}
