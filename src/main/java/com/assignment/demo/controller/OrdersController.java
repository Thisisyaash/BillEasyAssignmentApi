package com.assignment.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.demo.OrderNotFoundException;
import com.assignment.demo.model.OrdersModel;
import com.assignment.demo.service.OrdersServiceImp;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrdersServiceImp service;

	@PostMapping
	public OrdersModel addOrders(@Valid @RequestBody OrdersModel omodel) {
		log.info(omodel);
		return service.addOrders(omodel);
	}
	
	@GetMapping
	public List<OrdersModel> getorders(){
		return service.getOrders();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdersModel> getOrdersById(@PathVariable int id){
		return ResponseEntity.ok(service.getOrderById(id));
	}
	
	@GetMapping("/customer_id/{customerid}")
	public ResponseEntity<Map<String, Object>> getOrderByCustomerId(@PathVariable int customerid){
		List<OrdersModel> orderbyCustomerId = service.getOrdersByCustomerId(customerid);
		long totalOrderByCustomerId = service.getTotalOrderByCustomerId(customerid);
		
		Map<String, Object> response=new HashMap<String, Object>();
		response.put("orders", orderbyCustomerId);
		response.put("totalorders", totalOrderByCustomerId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/sum")
	public double getSum() {
		return service.getTotalRevenue();
	}
	
	@PutMapping("/{id}")
	public OrdersModel updateOrdersById(@PathVariable int id,@Valid @RequestBody OrdersModel omodel) {
		log.info(omodel.toString());
		log.info(id);
		return service.updateOrdersById(id, omodel);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrderById(@PathVariable int id) {
		return service.deleteOrderById(id);
	}
}
