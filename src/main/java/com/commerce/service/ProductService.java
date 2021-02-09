package com.commerce.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.commerce.entity.Product;

	@Repository
	public interface ProductService  extends JpaRepository<Product,Long> {
		@Query(value="SELECT * FROM productcommerce where name= :name", nativeQuery=true)
		public List<Product> findProductByName(@Param ("name") String name);
	}

