package com.assignment.demo.service;

import java.util.List;
import java.util.Optional;

import com.assignment.demo.model.OrdersModel;

public interface OrdersService {

	OrdersModel addOrders(OrdersModel omodel);
	
	List<OrdersModel> getOrders();
	
	OrdersModel getOrderById(int id);
	
	List<OrdersModel> getOrdersByCustomerId(int customerId);
	
	long getTotalOrderByCustomerId(int cid);
	
	double getTotalRevenue();
	
	OrdersModel updateOrdersById(int id,OrdersModel omodel);
	
	String deleteOrderById(int id);
}
