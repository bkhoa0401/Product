package com.ecommerce.wProductService.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetails implements Serializable{

	private static final long serialVersionUID = 3L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NUMBER")
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productID")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ordersID")
    private Orders orders;

    public OrderDetails(int number,Orders orders, Product product) {
        this.number = number;
        this.orders = orders;
        this.product = product;
    }
    

	public OrderDetails() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
    
    
}
