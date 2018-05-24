package com.product.service;

import java.util.List;

import com.product.dao.IProductDAO;
import com.product.dao.ProductDAOImpl;
import com.product.dto.Product;
import com.product.exception.ProductManagementSystemException;

public class ProductServiceImpl implements IProductService
{

	IProductDAO productDAO = new ProductDAOImpl();//Service class associates with the DAO class that accesses the database.
	@Override
	
	public int addProduct(Product product) throws ProductManagementSystemException {
	
		return productDAO.addProduct(product);
	}

	@Override
	public Product getProduct(int id) throws ProductManagementSystemException {
		
		return productDAO.getProduct(id);
	}

	@Override
	public void updateProduct(Product product) throws ProductManagementSystemException {
		
		productDAO.updateProduct(product);
	}

	@Override
	public Product removeProduct(int id) throws ProductManagementSystemException {
		
		return productDAO.removeProduct(id);
	}

	@Override
	public List<Product> getProducts() throws ProductManagementSystemException {
		
		return productDAO.getProducts();
	}
	
}
