package com.ecommerce.wProductService.entity.response;

import java.util.List;

import com.ecommerce.wProductService.entity.Product;

public class ProductsResponse extends BaseResponse<List<Product>>{

    public ProductsResponse(List<Product> products) {
        setMainResult(products);
    }
}
