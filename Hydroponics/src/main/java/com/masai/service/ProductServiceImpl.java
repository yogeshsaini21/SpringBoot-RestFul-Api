package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.CustomerDao;
import com.masai.dao.SessionDao;
import com.masai.dao.productDao;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	SessionDao sessionDao;
	
	@Autowired
	CustomerDao cs;
	
	@Autowired
	productDao ps;
	
	@Override
	public String addProduct(product prod, String key) {
		CurrentUserSession currentUser =  sessionDao.findByUuid(key);
		
		if(currentUser != null) {	
			Optional<Customer> cus=  cs.findById(prod.getCustomerID());
			cus.get().getProductList().add(prod);
//			cs.save(cus.get());
			if(cus.get().getType()==1) {
				 ps.save(prod);
				  return prod.toString()+" is added";
			}
			
			 
		  
			
		}
		return "Only Admin can add product";
	}

	@Override
	public List<product> ViewProduct(String Key) {
		
		Optional<Customer> cus = cs.findById(1);
		
		return cus.get().getProductList();
		
		
	}

	@Override
	public String DeleteProduct(Integer ID) {
	
		Optional<product> product =  ps.findById(ID);
		
		if(product!=null) {
			Optional<Customer> cus=  cs.findById(1);
			cus.get().getProductList().remove(product.get());
			ps.delete(product.get());
			
			return product.get().toString()+" is deleted";
			
		}
		
		return "Product with id "+ID+" doesn't exist";

	}
	
	
	
}
