package com.ecommerce.wFlowerService.repository;

import com.ecommerce.wFlowerService.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
