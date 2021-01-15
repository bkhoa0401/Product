package com.ecommerce.wFlowerService.repository;

import com.ecommerce.wFlowerService.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long> {
}
