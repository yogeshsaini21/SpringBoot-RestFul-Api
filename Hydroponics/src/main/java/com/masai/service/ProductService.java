package com.masai.service;

import java.util.List;

import com.masai.model.product;

public interface ProductService {

	public String addProduct(product prod , String key );
	
	public List<product> ViewProduct(String Key);
	
	
	public String DeleteProduct(Integer ID);
	
}
