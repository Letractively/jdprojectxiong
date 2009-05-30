package com.ejd.model.service.iface;
import java.util.List;
import com.ejd.web.bo.Product;
import com.ejd.model.exception.ProductException;


public interface IProductService {

	public Product getProductById(Integer id) throws ProductException;
	public Product getProductByCode(String code) throws ProductException;
	public List<Product> getAllProduct() throws ProductException;
	public Product addProduct(Product product) throws ProductException;
	public boolean delProductById(Integer id) throws ProductException;
	public boolean delProductByCode(String code) throws ProductException;
	public Product updateProduct(Product product) throws ProductException;
	public Product saveProduct(Product product) throws ProductException;
	public Product saveOrUpdateProduct(Product product) throws ProductException;
}
