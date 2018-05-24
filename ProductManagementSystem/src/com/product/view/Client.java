package com.product.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.*;
import java.util.Scanner;

import com.product.dto.Product;
import com.product.exception.ProductManagementSystemException;
import com.product.service.IProductService;
import com.product.service.ProductServiceImpl;

public class Client {

	private IProductService productService = null;

	public Client() {
		// super();

		productService = new ProductServiceImpl();
	}

	public void menu() {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) Add product");
		System.out.println("2) Get product");
		System.out.println("3) Update Product");
		System.out.println("4) Remove Product");
		System.out.println("5) View all products");
		System.out.println("6) Exit applications");

		System.out.println("\n Enter your choice");

		int choice = sc.nextInt();

		Operation(choice);
	}

	public void Operation(int choice) {
		switch (choice) {
		case 1:
			addProduct();
			break;
		case 2:
			getProduct();
			break;
		case 3:
			updateProduct();
			break;
		case 4:
			removeProduct();
			break;
		case 5:
			getAllProducts();
			break;
		case 6:
			System.out.println("Good bye\n");
			break;

		default:
			System.out.println("Please provide valid input");

			break;

		}
	}

	private void addProduct() {
		Scanner console = new Scanner(System.in);

		System.out.println("Add product details");
		System.out.println("Enter product name:");
		String productName = console.next();

		System.out.println("Enter product price:");
		double productPrice = console.nextDouble();

		System.out.println("Product Category");
		String category = console.next();

		System.out.println("m date");
		String date = console.next();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(date, format);
		Date mDate = java.sql.Date.valueOf(localDate);

		Product product = new Product(productName, productPrice, category, mDate);

		try {
			int proId = productService.addProduct(product);

			System.out.println("product added");
			System.out.println("product id" + proId);

		} catch (ProductManagementSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getProduct() {
		System.out.println("Enter id");
		Scanner console = new Scanner(System.in);
		int id = console.nextInt();
		try {
			Product product = productService.getProduct(id);

			System.out.println(product.getName());

		} catch (ProductManagementSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateProduct() {
		/**System.out.println("Enter id");
		Scanner console = new Scanner(System.in);
		int id = console.nextInt();
		
		Product product = **/

	}

	private void removeProduct() {
		System.out.println("Enter id");
		Scanner console = new Scanner(System.in);
		int id = console.nextInt();
		try {
			Product product = productService.removeProduct(id);

			System.out.println(product.getName());

		} catch (ProductManagementSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getAllProducts() {
		try {
			List<Product> products = productService.getProducts();
			//System.out.println("hi");
			Iterator<Product> it = products.iterator();
			while (it.hasNext()) {

				Product product = it.next();
				System.out.println(product.getId() + " " + 
				                   product.getName() + " " +
						           product.getPrice() + " " + 
				                   product.getCategory() + " " +
						           product.getManufactureDate());
			}

		} catch (ProductManagementSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Something went wrong"+e.getMessage());
		}

	}

	public static void main(String[] args) {

		Client client = new Client();
		while (true)
			client.menu();

	}

}