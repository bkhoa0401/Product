package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.OrderDetails;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
