package com.example.ev4s.controller;

import com.example.ev4s.entity.Customer;
import com.example.ev4s.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // 显示所有客户
    @GetMapping("/list")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer/list";  // 显示客户列表
    }

    // 显示单个客户
    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).orElse(null));
        return "customer/detail";  // 显示客户详情
    }

    // 显示添加客户页面
    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/add";  // 显示添加客户表单
    }

    // 处理添加客户请求
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";  // 添加后跳转到客户列表
    }

    // 显示编辑客户页面
    @GetMapping("/edit/{id}")
    public String showEditCustomerForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).orElse(null));
        return "customer/edit";  // 显示编辑客户表单
    }

    // 处理更新客户请求
    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        customer.setId(id);
        customerService.save(customer);
        return "redirect:/customer/list";  // 更新后跳转到客户列表
    }

    // 删除客户
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customer/list";  // 删除后跳转到客户列表
    }
}
