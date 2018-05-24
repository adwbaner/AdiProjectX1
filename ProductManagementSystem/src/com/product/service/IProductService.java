package com.product.service;

import java.util.List;

import com.product.dto.Product;
import com.product.exception.ProductManagementSystemException;

public interface IProductService
{
	public int addProduct(Product product) throws ProductManagementSystemException;
	
	public Product getProduct( int id) throws ProductManagementSystemException;
	
	public void updateProduct( Product product ) throws ProductManagementSystemException; 
	
	public Product removeProduct(  int id ) throws ProductManagementSystemException;
	
	public List<Product>getProducts() throws ProductManagementSystemException;
		
	}
		
