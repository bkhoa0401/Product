package com.ecommerce.wProductService.entity.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
