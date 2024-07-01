package com.assignment.demo.model;

import io.micrometer.common.lang.NonNullFields;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Customers")
@NonNullFields
public class CustomerModel {

	@Id
	@SequenceGenerator(allocationSize = 1,name = "Customer_Sequence",sequenceName = "Customer_Sequence")
	@GeneratedValue(generator = "Customer_Sequence",strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerid;
	
	 @NotEmpty(message = "Customer name cannot be empty")
	 @Size(min = 2, max = 100, message = "Customer name must be between 2 and 100 characters")
	@Column(name = "customer_name")
	private String customername;
	
	 @NotEmpty(message = "Email cannot be empty")
	 @Email(message = "Invalid email format")
	@Column(name = "custommer_email")
	private String customeremail;
	 
	@NotEmpty(message = "Address cannot be empty")
	@Column(name = "customer_address")
	private String customeraddress;
}
