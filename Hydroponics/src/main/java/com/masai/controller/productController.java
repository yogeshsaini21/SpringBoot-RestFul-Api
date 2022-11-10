package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.product;
import com.masai.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class productController {
	
	@Autowired
	private ProductService ps;
	

	
	@PostMapping("/add-Product/{key}")
	public ResponseEntity<String> addProduct(@RequestBody product prod , @PathVariable("key") String Key){
		 
		String str = ps.addProduct(prod,Key);
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/ViewProduct")
	public ResponseEntity<List<product>> ViewProduct(String Key){
		
		List<product> li = ps.ViewProduct(Key);
		
		return new ResponseEntity<List<product>>(li, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/Delete=Product/{id}")
	public ResponseEntity<String> DeleteProduct(@PathVariable("id") Integer ID){
		
		String st = ps.DeleteProduct(ID);
		return new ResponseEntity<String>(st, HttpStatus.ACCEPTED);
		
	}
	
}
