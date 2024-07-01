package com.assignment.demo.service;

import java.util.List;
import java.util.Optional;

import com.assignment.demo.model.CustomerModel;

public interface CustomerService {

	CustomerModel addcustomer(CustomerModel cmodel);
	
	List<CustomerModel> getcustomers();
	
	CustomerModel getCustomerById(int id);
	
	CustomerModel updateCustomerById(int id,CustomerModel cmodel);
	
	Optional<CustomerModel> deleteCustomerById(int id);
}
