package com.ecommerce.wProductService.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="CODEPRODUCT", columnDefinition = "VARCHAR(50)")
    private String codeProduct;

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
    
    @Column(name = "SIZE", columnDefinition = "NVARCHAR(200)")
    private String size;

    @Column(name = "CREATIONTIME", columnDefinition = "datetime")
    private Date creationTime;

    @Column(name = "ENABLE" , columnDefinition = "VARCHAR(1) default 'T'")
    private String enable = "T";

    @ManyToOne
    @JoinColumn(name = "producttypedetail_id")
    private ProductTypeDetail productTypeDetailID;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLinkDetail() {
		return linkDetail;
	}

	public void setLinkDetail(String linkDetail) {
		this.linkDetail = linkDetail;
	}

	public String getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}

	public String getImagesDetail() {
		return imagesDetail;
	}

	public void setImagesDetail(String imagesDetail) {
		this.imagesDetail = imagesDetail;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public ProductTypeDetail getProductTypeDetailID() {
		return productTypeDetailID;
	}

	public void setProductTypeDetailID(ProductTypeDetail productTypeDetailID) {
		this.productTypeDetailID = productTypeDetailID;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
    
}

