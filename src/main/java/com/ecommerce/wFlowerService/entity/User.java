package com.ecommerce.wFlowerService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column(name = "USERID" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long userID;

    @Column(name = "USERNAME" , columnDefinition = "VARCHAR(100)")
    private String username;

    @Column(name = "PASSWORD" ,  columnDefinition = "VARCHAR(200)")
    @JsonIgnore
    private String password;

    @Column(name = "NAME" ,  columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "PHONE" , columnDefinition = "VARCHAR(15)")
    private String phone;

    @Column(name = "ADDRESS" ,  columnDefinition = "NVARCHAR(100)")
    private String address;

    @Column(name = "EMAIL" , columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "CREATIONTIME" , columnDefinition = "datetime")
    @JsonIgnore
    private Timestamp creationTime;

    @Column(name = "ACTIVETIME" , columnDefinition = "datetime")
    @JsonIgnore
    private Timestamp activeTime;

    @Column(name = "ENABLE" , columnDefinition = "VARCHAR(1) default 'F'")
    private String enable;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleID;
}

