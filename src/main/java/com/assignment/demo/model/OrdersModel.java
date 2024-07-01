package com.assignment.demo.model;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "Orders")
public class OrdersModel {

	@Id
	@SequenceGenerator(allocationSize = 1,name = "orders_Sequence",sequenceName = "orders_Sequence")
	@GeneratedValue(generator = "orders_Sequence",strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@jakarta.validation.constraints.NotNull(message = "Product price cannot be null")
    @PositiveOrZero(message = "Product price must be positive or zero")
	private int quantity;
	private Date order_date;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomerModel customermodel;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductsModel productsmodel;
	
	@PrePersist
	public void setDate() {
		this.order_date=new Date();
	}

	public void updateDate(Date order_date2) {
		this.order_date=order_date2;
	}
}
