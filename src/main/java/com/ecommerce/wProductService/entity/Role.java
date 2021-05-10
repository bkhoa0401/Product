package com.ecommerce.wProductService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROLE")
@Setter
@Getter
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
}
