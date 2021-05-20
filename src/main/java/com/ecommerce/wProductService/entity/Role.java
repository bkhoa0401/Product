package com.ecommerce.wProductService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 5L;

	@Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "NAME", columnDefinition = "NVARCHAR(20)")
    private String name;

    @OneToMany(mappedBy = "roleID")
    @JsonIgnore
    private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Role() {
		super();
	}
    
}
