package com.example.ev4s.controller;

import com.example.ev4s.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory/list")
    public String getAllInventoryItems(Model model) {
        // 从服务层获取所有库存项
        model.addAttribute("inventory", inventoryService.findAll());
        return "inventory/list";  // 返回 inventory/list.html 视图
    }
}
