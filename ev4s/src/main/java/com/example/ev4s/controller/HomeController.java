package com.example.ev4s.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "index";  // 返回 index.html 页面
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // 返回 login.html 页面
    }
}
