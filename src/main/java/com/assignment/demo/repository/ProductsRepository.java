package com.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.demo.model.ProductsModel;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsModel, Integer> {

}
