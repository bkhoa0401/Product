package com.ecommerce.wProductService.service;

import java.util.List;

import com.ecommerce.wProductService.entity.Product;


public interface IProductService {

     List<Product> getProducts();

     List<Product> getProductsByProductTypeDetail(long id);

     Product getProductById(long id);

     void addNewProduct(Product product);

     void updateProduct(Product product);
     
     List<Product> getProductsByProductType(long id);

}
