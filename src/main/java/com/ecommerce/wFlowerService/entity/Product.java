package com.ecommerce.wFlowerService.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @Column(name = "ID" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", columnDefinition = "NVARCHAR(500)")
    private String name;

    @Column(name = "IMAGE", columnDefinition = "VARCHAR(500)")
    private String image;

    @Column(name = "LINKDETAIL", columnDefinition = "VARCHAR(200)")
    private String linkDetail;

    @Column(name = "OLDPRICE", columnDefinition = "VARCHAR(50)")
    private String oldPrice;

    @Column(name = "NEWPRICE", columnDefinition = "VARCHAR(50)")
    private String newPrice;

    @Column(name = "IMAGESDETAIL", columnDefinition = "VARCHAR(3000)")
    private String imagesDetail;

    @Column(name = "CREATIONTIME", columnDefinition = "datetime")
    private Date creationTime;

    @Column(name = "ENABLE" , columnDefinition = "VARCHAR(1) default 'T'")
    private String enable = "T";

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branchID;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetails> orderDetails;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", linkDetail='" + linkDetail + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", imagesDetail='" + imagesDetail + '\'' +
                '}';
    }
}

