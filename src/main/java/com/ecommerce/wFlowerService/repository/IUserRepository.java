package com.ecommerce.wFlowerService.repository;

import com.ecommerce.wFlowerService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String userName);
}
