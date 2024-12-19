package com.example.ev4s.repository;

import com.example.ev4s.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// UserRepository 继承 JpaRepository，提供对 User 实体的 CRUD 操作
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);  // 根据用户名查找用户
}
