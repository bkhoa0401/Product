package com.ecommerce.wFlowerService.service;

import com.ecommerce.wFlowerService.entity.Product;

import java.util.List;


public interface IProductService {

     List<Product> getProducts();

     Product getProductById(long id);

     void addNewProduct(Product product);

}
