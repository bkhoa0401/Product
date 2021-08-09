package com.ecommerce.wProductService.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PRODUCTTYPE")
public class ProductType implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "ENABLE" , columnDefinition = "VARCHAR(1) default 'T'")
    private String enable = "T";
	
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
	//@JsonIgnore
	private Set<ProductTypeDetail> productTypeDetails;

	public ProductType() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Set<ProductTypeDetail> getProductTypeDetails() {
		return productTypeDetails;
	}

	public void setProductTypeDetails(Set<ProductTypeDetail> productTypeDetails) {
		this.productTypeDetails = productTypeDetails;
	}
}
