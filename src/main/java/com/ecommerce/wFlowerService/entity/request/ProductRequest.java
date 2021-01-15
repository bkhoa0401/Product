package com.ecommerce.wFlowerService.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
