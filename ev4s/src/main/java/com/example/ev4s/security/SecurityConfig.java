package com.example.ev4s.security;

import com.example.ev4s.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 配置授权
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/login", "/register", "/customer/list", "/customer/add", "/customer/edit/*", "/customer/delete/*").permitAll()  // 开放这些页面
                                .anyRequest().authenticated()  // 其他请求需要认证
                )
                // 配置登录
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")  // 登录页面 URL（不要设置为需要登录的页面）
                                .defaultSuccessUrl("/dashboard", true)  // 登录成功后默认跳转到此页面
                                .permitAll()  // 允许所有用户访问登录页面
                )
                // 配置登出
                .logout(logout ->
                        logout.permitAll()  // 允许所有用户访问登出
                )
                // 禁用 CSRF（如果不需要的话）
                .csrf(csrf -> csrf.disable());  // 可选：禁用 CSRF，默认情况下 Spring Security 启用 CSRF 防护

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // 使用 BCrypt 加密密码
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return userService;  // 使用自定义的 UserService 实现 UserDetailsService
    }
}
