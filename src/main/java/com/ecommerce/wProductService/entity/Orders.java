package com.ecommerce.wProductService.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 4L;

	@Id
    @Column(name = "orderID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderID;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private Set<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    public Orders(String name, User user) {
        this.name = name;
        this.user = user;
    }

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
