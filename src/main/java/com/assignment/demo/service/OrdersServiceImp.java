package com.assignment.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.assignment.demo.model.OrdersModel;
import com.assignment.demo.repository.OrdersRepository;

import lombok.extern.log4j.Log4j2;
	
@Service
@Log4j2
public class OrdersServiceImp implements OrdersService{
	
	@Autowired
	private OrdersRepository ordersRepo;

	@Override
	public OrdersModel addOrders(OrdersModel omodel) {
		ordersRepo.save(omodel);
		return omodel;
	}

	@Override
	public List<OrdersModel> getOrders() {
		return ordersRepo.findAll();	
	}

	@Override
	public OrdersModel getOrderById(int id) {
		return ordersRepo.findById(id).orElse(null);
	}
	
	 public List<OrdersModel> getOrdersByCustomerId(int customerId) {
	        return ordersRepo.findByCustomermodel_Customerid(customerId);
	}

	@Override
	public long getTotalOrderByCustomerId(int cid) {
		
		return ordersRepo.findByCustomermodel_Customerid(cid).size();
	}

	@Override
	public double getTotalRevenue() {
		return ordersRepo.findTotalRevenue();
	}

	@Override
	public OrdersModel updateOrdersById(int id, OrdersModel omodel) {
		 OrdersModel existingOrder = ordersRepo.findById(id).orElse(null);
		 log.info(ordersRepo.findById(id));
		 if(existingOrder!=(null)) {
			 existingOrder.setQuantity(omodel.getQuantity());
			 existingOrder.updateDate(omodel.getOrder_date());
			 existingOrder.setCustomermodel(omodel.getCustomermodel());
			 existingOrder.setProductsmodel(omodel.getProductsmodel());
			 ordersRepo.save(existingOrder);
			 return existingOrder;
			 
		 }
		
		return null;
	}

	@Override
	public String deleteOrderById(int id) {
		if (ordersRepo.existsById(id)) {
            ordersRepo.deleteById(id);
            return "Record deleted successfully";
        } else {
            return "Record with ID " + id + " not found";
        }
	}

}
