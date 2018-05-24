package com.product.test;

import java.util.Date;

import com.product.dto.Product;
import com.product.service.IProductService;
import com.product.service.ProductServiceImpl;

public class TestProductService {

	public static void main(String[] args) {

		IProductService productService = new ProductServiceImpl();
		
		Product product = new Product("LenovoPlus",6500,"Mobiles",new Date());
		
		try {
			int id = productService.addProduct( product );
			
			System.out.println("Product id " +id) ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
