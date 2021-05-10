package com.ecommerce.wProductService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "BRANCH")
@Getter
@Setter
public class Branch implements Serializable {

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

    @OneToMany(mappedBy = "branchID")
    @JsonIgnore
    private List<Product> products;

    @Column(name = "ENABLE" , columnDefinition = "VARCHAR(1) default 'T'")
    private String enable = "T";

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", enable='" + enable + '\'' +
                '}';
    }
}
