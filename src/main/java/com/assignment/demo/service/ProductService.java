package com.assignment.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.demo.model.ProductsModel;
import com.assignment.demo.repository.ProductsRepository;

@Service
public class ProductService {

	@Autowired
	private ProductsRepository productrepo;

	public boolean saveprodut(ProductsModel pmodel) {
		if (productrepo.save(pmodel).equals(pmodel)) {
			return true;
		} else
			return false;

	}
	
	public List<ProductsModel> getproducts() {
		return productrepo.findAll();
	}
	
	public ProductsModel getproductbyid(int id) {
		ProductsModel products= productrepo.findById(id).orElse(null);
		return products;
	}
	
	public ProductsModel updateproductbyid(int id,ProductsModel model) {
		Optional<ProductsModel> byId = productrepo.findById(id);
		if(byId.isPresent()) {
			ProductsModel productsModel = byId.get();
			productsModel.setName(model.getName());
			productsModel.setDescription(model.getDescription());
			productsModel.setPrice(model.getPrice());
			productsModel.setQuantity(model.getQuantity());
			ProductsModel result = productrepo.save(productsModel);
			return result;
			
		}else{
			return null;
		}
		
	}
	
	public void deletebyid(int id) {
		productrepo.deleteById(id);
	}
}
