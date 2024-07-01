package com.assignment.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.demo.model.CustomerModel;
import com.assignment.demo.model.ProductsModel;
import com.assignment.demo.repository.CustomersRepository;

@Service
public class CustomerServiceimp implements CustomerService{
	
	@Autowired
	private CustomersRepository customerrepo;

	@Override
	public CustomerModel addcustomer(CustomerModel cmodel) {
		customerrepo.save(cmodel);
		return cmodel;
	}

	@Override
	public List<CustomerModel> getcustomers() {
		return customerrepo.findAll();
	}

	@Override
	public CustomerModel getCustomerById(int id) {
		return customerrepo.findById(id).orElse(null);
	}
	

	@Override
	public CustomerModel updateCustomerById(int id, CustomerModel cmodel) {
		Optional<CustomerModel> byId = customerrepo.findById(id);
		if(byId.isPresent()) {
			CustomerModel customerModel = byId.get();
			customerModel.setCustomername(cmodel.getCustomername());
			customerModel.setCustomeremail(cmodel.getCustomeremail());
			customerModel.setCustomeraddress(cmodel.getCustomeraddress());
			CustomerModel result = customerrepo.save(customerModel);
			return result;
		}
		return null;
	}

	@Override
	public  Optional<CustomerModel> deleteCustomerById(int id) {
		Optional<CustomerModel> deletedcustomer = customerrepo.findById(id);
		customerrepo.deleteById(id);
		return deletedcustomer;
	}

	
}
