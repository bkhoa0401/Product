package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.Orders;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long> {
}
