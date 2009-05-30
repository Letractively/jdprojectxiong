package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.web.bo.Product;

public interface IProductDao {
	public Product getProductById(Integer id);
	public Product getProductByCode(String code);
	public List<Product> getAllProduct();
	public Product addProduct(Product product);
	public boolean delProductById(Integer id);
	public boolean delProductByCode(String brandCode);
	public Product updateProduct(Product product);
	public Product saveProduct(Product product);
	public Product saveOrUpdateProduct(Product product);
}
