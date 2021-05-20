package com.ecommerce.wProductService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.wProductService.entity.ProductTypeDetail;

public interface IProductTypeDetailRepository extends JpaRepository<ProductTypeDetail,Long> {

    List<ProductTypeDetail> findProductTypeDetailByEnable(String status);
    List<ProductTypeDetail> findProductTypeDetailByProductTypeId(long id);

}
