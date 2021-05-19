package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.ProductType;

import java.util.List;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType,Long> {

    List<ProductType> findProductTypeByEnable(String status);
}
