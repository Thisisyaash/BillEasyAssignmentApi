package com.assignment.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.demo.model.CustomerModel;

@Repository
public interface CustomersRepository extends JpaRepository<CustomerModel, Integer>{

}
