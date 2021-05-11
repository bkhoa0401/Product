package com.ecommerce.wProductService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTTYPE")
@Getter
@Setter
public class ProductType implements Serializable{
	 
		private static final long serialVersionUID = 2L;

		@Id
	    @Column(name = "ID", nullable = false)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name = "NAME", columnDefinition = "VARCHAR(50)")
	    private String name;
}
