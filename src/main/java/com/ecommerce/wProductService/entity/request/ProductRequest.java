package com.ecommerce.wProductService.entity.request;

public class ProductRequest {

    private String productID;
    private int number;

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productID='" + productID + '\'' +
                ", number=" + number +
                '}';
    }

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
