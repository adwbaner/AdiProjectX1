package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.db.DBUtill;
import com.product.dto.Product;
import com.product.exception.ProductManagementSystemException;

public class ProductDAOImpl implements IProductDAO
{
	
	public int generateProductId() throws ProductManagementSystemException
	{
		int productId=0;
		
		try(Connection con=DBUtill.getConnection())
		{
			Statement stm=con.createStatement();
			ResultSet res=stm.executeQuery("select pro_id_seq.nextVal from dual");
			
			if(res.next()==false)
					throw new ProductManagementSystemException("could not generate product id");
			productId=res.getInt(1);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			throw new ProductManagementSystemException(e);
			
		} 
		
		return productId;
		
	}
	
	
	@Override
	public int addProduct(Product product) throws ProductManagementSystemException {
		
		//generate id
		//add product to database
		
		int productId=0;
		
		try(Connection con=DBUtill.getConnection())
		{
			product.setId(generateProductId() );
			
			PreparedStatement pstm=con.prepareStatement("insert into Product values(?,?,?,?,?)");
			
			pstm.setInt(1, product.getId());
			pstm.setString(2, product.getName());
			pstm.setDouble(3, product.getPrice());
			pstm.setString(4, product.getCategory());
			
			//conversion of util date to sql date
			long dateValue=	product.getManufactureDate().getTime();//Entire util date assigned to dateValue
			System.out.println("hi");
			java.sql.Date date=new java.sql.Date(dateValue);
			pstm.setDate(5, date);
			
			//product detail inserted
			pstm.execute();
			
			productId=product.getId();
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			throw new ProductManagementSystemException(e); 
		
		}
		
		return productId;
	}

	@Override
	public Product getProduct(int productId) throws ProductManagementSystemException {
		
		Product product=new Product();
		
		try(Connection con=DBUtill.getConnection())
		{
			PreparedStatement pstm=con.prepareStatement("select * from product where id=?");
			
			pstm.setInt(1, productId);
			System.out.println("hi");
			ResultSet res=pstm.executeQuery();
			
			res.next();
			
			
		//	product=new Product();
			
			product.setId(res.getInt(1));
			product.setName(res.getString(2));
			product.setPrice(res.getDouble(3));
			product.setCategory(res.getString(4));
			product.setManufactureDate(res.getDate(5));
			
			
			
			
		}
		catch (ClassNotFoundException | SQLException e)
		{
			throw new ProductManagementSystemException(e); 
		
		}
		
		
		return product;
	}

	@Override
	public void updateProduct(Product product) throws ProductManagementSystemException {
	
		
	}

	@Override
	public Product removeProduct(int id) throws ProductManagementSystemException {
	
		Product product=new Product();
		try(Connection con=DBUtill.getConnection()){
			PreparedStatement pstm1=con.prepareStatement("select * from product where id=?");
			
			pstm1.setInt(1, id);
			System.out.println("hi");
			ResultSet res=pstm1.executeQuery();
			
			res.next();
			
			
		//	product=new Product();
			
			product.setId(res.getInt(1));
			product.setName(res.getString(2));
			product.setPrice(res.getDouble(3));
			product.setCategory(res.getString(4));
			product.setManufactureDate(res.getDate(5));
				
		//product=getProduct(id);
		
		PreparedStatement pstm=con.prepareStatement("delete from product where id=?");
			pstm.setInt(1, id);
			pstm.executeQuery();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getProducts() throws ProductManagementSystemException {
		
		List<Product> products=null;
		
		try(Connection con=DBUtill.getConnection()){
			Statement stm=con.createStatement();
			ResultSet res=stm.executeQuery("Select * from product");
		if(res.next()==false) throw new ProductManagementSystemException();
		
		products = new ArrayList<Product>();
		do
		{	
			
			Product product =new Product();
			product.setId(res.getInt(1));
			product.setName(res.getString(2));
			product.setPrice(res.getDouble(3));
			product.setCategory(res.getString(4));
			product.setManufactureDate(res.getDate(5));
			
			products.add(product);
			System.out.println("hi");
		}while(res.next());
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return null;//Ye gadbadi kari thi bhosdi ke tune
		return products;
	}
	
}
