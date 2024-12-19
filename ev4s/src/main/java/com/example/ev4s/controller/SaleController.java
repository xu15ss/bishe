package com.example.ev4s.controller;

import com.example.ev4s.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/sale/list")
    public String getAllSales(Model model) {
        model.addAttribute("sales", saleService.findAll());
        return "sale/list";
    }
}
