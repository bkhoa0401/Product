package com.ecommerce.wProductService.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ORDERDETAILS")
@Getter
@Setter
@NoArgsConstructor
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
}
