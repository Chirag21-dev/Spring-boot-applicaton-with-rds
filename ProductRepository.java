package com.eustache.spring_rds_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eustache.spring_rds_demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
