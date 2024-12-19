package com.example.ev4s.service;

import com.example.ev4s.entity.Customer;
import com.example.ev4s.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // 获取所有客户
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // 根据ID查找客户
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    // 保存新客户或更新现有客户
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    // 删除客户
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
