package com.ecommerce.wProductService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

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

    @Column(name = "FAILLOGINCOUNT", columnDefinition = "int default 0")
    private int failLoginCount;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleID;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

	public User() {
		super();
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Timestamp activeTime) {
		this.activeTime = activeTime;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public int getFailLoginCount() {
		return failLoginCount;
	}

	public void setFailLoginCount(int failLoginCount) {
		this.failLoginCount = failLoginCount;
	}

	public Role getRoleID() {
		return roleID;
	}

	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
}

