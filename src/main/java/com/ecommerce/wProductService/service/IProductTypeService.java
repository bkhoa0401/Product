package com.ecommerce.wProductService.service;

import java.util.List;

import com.ecommerce.wProductService.entity.ProductType;


public interface IProductTypeService {

    List<ProductType> getProductType();
    void addNewProductType(ProductType productType);
    void updateProductType(ProductType productType);
}
