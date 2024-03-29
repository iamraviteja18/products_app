package com.rakuten.training.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rakuten.training.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	public List<Product> findByNameLike(String name);

}
