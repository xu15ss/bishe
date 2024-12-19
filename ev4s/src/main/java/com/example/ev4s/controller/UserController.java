package com.example.ev4s.controller;

import com.example.ev4s.entity.User;
import com.example.ev4s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 显示登录页面
    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

    // 处理登录请求
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("message", "Login Successful");
            return "redirect:/customer/list";
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "user/login";
        }
    }
}
