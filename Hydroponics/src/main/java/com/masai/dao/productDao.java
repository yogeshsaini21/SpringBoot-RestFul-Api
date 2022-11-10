package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.product;

@Repository
public interface productDao extends JpaRepository<product, Integer> {

	
}
