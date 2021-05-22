package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product p where p.enable = 'T' and p.producttypedetail_id in " +
            " ( select id from producttypedetail where enable = 'T') limit 5", nativeQuery = true)
    List<Product> findProducts();

    @Query(value = "select * from product p where p.enable = 'T' and p.producttypedetail_id = ?", nativeQuery = true)
    List<Product> findProductsByProductTypeDetail(long id);

    @Query(value = "select * from product p where p.enable = 'T' and p.id = ?", nativeQuery = true)
    Product findProductsById(long id);
}
