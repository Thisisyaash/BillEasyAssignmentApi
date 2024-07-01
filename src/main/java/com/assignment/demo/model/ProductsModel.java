package com.assignment.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductsModel {

	@Id
	@SequenceGenerator(allocationSize = 1,name = "Products_Sequence",sequenceName = "Products_Sequence")
	@GeneratedValue(generator = "Products_Sequence",strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productid;
	
	@NotEmpty(message = "Product name cannot be empty")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
	@Column(name = "products_name")
	private String name;
	
	@NotEmpty(message = "Product description cannot be empty")
	@Column(name = "products_description")
	private String description;
	
	@NotNull(message = "Product price cannot be null")
    @PositiveOrZero(message = "Product price must be positive or zero")
	@Column(name = "products_price")
	private float price;
	
	@NotNull(message = "Product price cannot be null")
    @PositiveOrZero(message = "Product quantity must be positive or zero")
	@Column(name = "product_quantity")
	private int quantity;
}
