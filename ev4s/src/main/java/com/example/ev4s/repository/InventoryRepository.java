package com.example.ev4s.repository;

import com.example.ev4s.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // JpaRepository 提供了许多基本的数据库操作方法，包括 findAll()
}
