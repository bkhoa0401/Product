package com.ecommerce.wFlowerService.entity.response;

import com.ecommerce.wFlowerService.entity.Product;

import java.util.List;

public class ProductsResponse extends BaseResponse<List<Product>>{

    public ProductsResponse(List<Product> products) {
        setMainResult(products);
    }
}
