package com.assignment.demo.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.demo.model.ProductsModel;
import com.assignment.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductService service;

	@PostMapping
	public boolean addproduct(@Valid @RequestBody ProductsModel model) {
		boolean saveprodut = service.saveprodut(model);
		return saveprodut;
	}

	@GetMapping
	public List<ProductsModel> getproduct() {
		return service.getproducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductsModel> getproductbyid(@PathVariable int id) {
		ProductsModel getproductbyid = service.getproductbyid(id);
		if(getproductbyid!=null) {
			return ResponseEntity.ok(getproductbyid);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ProductsModel updateproductbyid(@PathVariable int id,@Valid @RequestBody ProductsModel model) {
		return service.updateproductbyid(id, model);
	}
	
	@DeleteMapping("/{id}")
	public void deleteproductbyid(@PathVariable int id) {
		service.deletebyid(id);
	}
}
