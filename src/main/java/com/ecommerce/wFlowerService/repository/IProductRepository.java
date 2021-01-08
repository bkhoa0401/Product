package com.ecommerce.wFlowerService.repository;

import com.ecommerce.wFlowerService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from product p where p.enable = 'T' and p.branch_id in " +
            " ( select id from branch where enable = 'T')", nativeQuery = true)
    List<Product> findProducts();

    @Query(value = "select * from product p where p.enable = 'T' and p.branch_id = ?", nativeQuery = true)
    List<Product> findProductsByBranchID(long id);
}
