package com.assignment.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.demo.model.CustomerModel;
import com.assignment.demo.service.CustomerServiceimp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceimp service;

	@PostMapping
	public CustomerModel addcustomer(@Valid @RequestBody CustomerModel model) {
		return service.addcustomer(model);
	}
	
	@GetMapping
	public List<CustomerModel> getcustomers(){
		return service.getcustomers();
	}
	
	@GetMapping("/{id}")
	public CustomerModel getCustomerById(@PathVariable int id) {
		return service.getCustomerById(id);
	}
	
	@PutMapping("/{id}")
	public CustomerModel updateCustomerById(@PathVariable int id,@Valid @RequestBody CustomerModel cmodel) {
		return service.updateCustomerById(id, cmodel);
	}
	
	@DeleteMapping("/{id}")
	public Optional<CustomerModel> deleteCustomerById(@PathVariable int id) {
		return service.deleteCustomerById(id);
	}
}
