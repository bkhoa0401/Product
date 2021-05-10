package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByName(String name);
}
