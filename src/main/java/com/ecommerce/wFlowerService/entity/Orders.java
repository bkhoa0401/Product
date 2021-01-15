package com.ecommerce.wFlowerService.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
public class Orders {

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
}
