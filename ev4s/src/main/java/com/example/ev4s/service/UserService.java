package com.example.ev4s.service;

import com.example.ev4s.repository.UserRepository;  // 导入 UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;  // 注入 UserRepository

    // 根据用户名查找用户
    public com.example.ev4s.entity.User findByUsername(String username) {
        return userRepository.findByUsername(username);  // 调用 UserRepository 查找用户
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 使用自定义的 User 实体类，使用完全限定名
        com.example.ev4s.entity.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // 使用 Spring Security 的 User 类来创建 UserDetails 对象
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(() -> user.getRole())  // 将角色转换为 GrantedAuthority
        );
    }
}
