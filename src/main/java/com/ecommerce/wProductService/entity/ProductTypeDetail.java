package com.ecommerce.wProductService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PRODUCTTYPEDETAIL")
public class ProductTypeDetail implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(50)")
    private String name;

    @OneToMany(mappedBy = "productTypeDetailID", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;
    
    @ManyToOne
    @JoinColumn(name = "producttype_id")
    private ProductType productType;

    @Column(name = "ENABLE" , columnDefinition = "VARCHAR(1) default 'T'")
    private String enable = "T";
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", enable='" + enable + '\'' +
                '}';
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
}
