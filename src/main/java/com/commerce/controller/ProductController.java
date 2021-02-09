package com.commerce.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.entity.Product;
import com.commerce.exception.ProductNotfoundException;
import com.commerce.service.ProductService;

@RestController
public class ProductController {
		Logger logger = LoggerFactory.getLogger(ProductController.class);
		/*
		 * method to submit the form request from client
		 */
		@Autowired ProductService productService;
		@PostMapping(path="/postproduct")	
        public Product submitProduct(@RequestBody Product product) {
		                  logger.info("User value passed is"+product.getName());
		                  productService.save(product);
		                               return product;
		                 } 
		/*
		 * method to get the data from database
		 * using custom exception
		 */
		@GetMapping(path="/getproduct") 
		public List<Product> getProduct() throws IOException {
		         List<Product> listProduct=  productService.findAll();
		         if(!listProduct.isEmpty())
				   {
		        	 return listProduct;
				   }
		         else {
				throw new ProductNotfoundException();
				}
			}
		/*
		 * Method used to get single product by name
		 * Once the product is shown, hyperlink can be provided to update the fields
		 */
		@GetMapping(path="/getproduct/{name}") 
		 public List<Product> getProduct(@PathVariable String name) throws IOException, ProductNotfoundException {
		         List<Product> listUser=  productService.findProductByName(name);
				return listUser;
    }
		/*
		 * Method used to delete the product by name
		 */
		
		@DeleteMapping(value = "/deleteproduct/{name}") 
		 public void deleteProduct(@PathVariable String name) throws IOException {
			Product product = new Product();
			product.setName(name);
			productService.delete(product);
		}
}
