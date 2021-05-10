package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.Branch;

import java.util.List;

@Repository
public interface IBranchRepository extends JpaRepository<Branch,Long> {

    List<Branch> findBranchesByEnable(String status);
}
