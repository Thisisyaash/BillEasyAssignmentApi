package com.assignment.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.demo.model.OrdersModel;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersModel, Integer>{
	List<OrdersModel> findByCustomermodel_Customerid (int cid);
	
	@Query("SELECT SUM(o.quantity * p.price) FROM OrdersModel o JOIN o.productsmodel p")
	double findTotalRevenue();

}
