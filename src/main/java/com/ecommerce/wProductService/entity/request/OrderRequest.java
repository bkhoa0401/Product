package com.ecommerce.wProductService.entity.request;

import java.util.List;

public class OrderRequest {

    private String username;
    private String ordername;
    private List<ProductRequest> products;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "username='" + username + '\'' +
                ", ordername='" + ordername + '\'' +
                ", products=" + products +
                '}';
    }


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getOrdername() {
		return ordername;
	}


	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}


	public List<ProductRequest> getProducts() {
		return products;
	}


	public void setProducts(List<ProductRequest> products) {
		this.products = products;
	}
    
}
