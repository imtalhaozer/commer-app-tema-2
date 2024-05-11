package com.hardwarestore.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hardwarestore.shop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
