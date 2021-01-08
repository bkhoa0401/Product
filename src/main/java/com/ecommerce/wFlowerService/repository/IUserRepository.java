package com.ecommerce.wFlowerService.repository;

import com.ecommerce.wFlowerService.entity.Role;
import com.ecommerce.wFlowerService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String userName);
    List<User> findUserByRoleID(Role role);
}
